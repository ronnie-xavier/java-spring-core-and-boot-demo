package cloud.itsu.springbootdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

@Service
@Slf4j
public class FileHandlingService {

    public static final String FILE_DIR = "./src/main/resources/files/";
    public static final String INPUT_FILE_PATH = "./src/main/resources/files/input.csv";
    public static final String OUTPUT_FILE_PATH = "./src/main/resources/files/output.csv";
    public static final String MANUAL_OUTPUT_PATH = "./src/main/resources/files/manual_output.csv";
    public static final String SCANNER_OUTPUT_PATH = "./src/main/resources/files/scanner_output.csv";

    public String createNewFile() {
        File file = new File(INPUT_FILE_PATH);
        try {
            if(file.createNewFile()) {
                log.info("file created successfully");
            } else {
                log.info("file already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(file.getAbsolutePath());

        writeToFile();
        return "success";
    }

    private void writeToFile() {
        try {
            FileWriter writer = new FileWriter(INPUT_FILE_PATH);
            writer.write("but it will erase everything previously written");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playWithByteStreams() throws IOException {

        try (FileInputStream in = new FileInputStream(INPUT_FILE_PATH);
             FileOutputStream out = new FileOutputStream(OUTPUT_FILE_PATH)) {

            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }

    }

    public void playWithCharStreams() throws IOException {

        try (FileReader in = new FileReader(INPUT_FILE_PATH);
             FileWriter out = new FileWriter(OUTPUT_FILE_PATH)) {
            int c;

            while ((c = in.read()) != -1) {
                BigInteger bigInteger = BigInteger.valueOf(c);
                System.out.println(bigInteger.toByteArray().toString());
                out.write(c);
            }
        }
    }

    public void playWithManualStreams() throws IOException {

        InputStream in = IOUtils.toInputStream("utf 16 ആ abc \n 1.23 ronnie / 4.15 abcd", "UTF-16");
        int c;

        FileOutputStream out = new FileOutputStream(MANUAL_OUTPUT_PATH) ;

        while ((c = in.read()) != -1) {
            out.write(c);
        }
        out.close();
    }

    public void playWithManualByteArrayStreams() throws IOException {

        byte[] in = "utf 8 ആ abc \n 1.23 ronnie / 4.15 mnop".getBytes(StandardCharsets.UTF_8);

        FileOutputStream out = new FileOutputStream(MANUAL_OUTPUT_PATH) ;

        out.write(in);
        out.close();
    }

    public void playWithScanner() throws IOException {

        Scanner input = new Scanner(new BufferedReader(new FileReader(MANUAL_OUTPUT_PATH)));
        input.useLocale(Locale.US);
        BufferedWriter output = new BufferedWriter(new FileWriter(SCANNER_OUTPUT_PATH));

        while (input.hasNext()) {
            if(input.hasNextDouble()) {
                output.write("" + input.nextDouble() + " ");
            } else {
                System.out.println(input.next());
            }
        }

        input.close();
        output.close();
    }


    public String uploadFile(MultipartFile file) throws IOException {
        String path = FILE_DIR + file.getOriginalFilename();
        byte[] fileContent = file.getInputStream().readAllBytes();

        FileOutputStream uploadedFile = new FileOutputStream(path);
        uploadedFile.write(fileContent);

        return "ok";
    }

    public byte[] downloadFile(String name) throws IOException {
        FileInputStream in = new FileInputStream(FILE_DIR + name);
        return in.readAllBytes();
    }
}
