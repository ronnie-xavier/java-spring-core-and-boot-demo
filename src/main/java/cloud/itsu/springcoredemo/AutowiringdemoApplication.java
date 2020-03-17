package cloud.itsu.springcoredemo;

import cloud.itsu.springcoredemo.components.TextEditor;
import cloud.itsu.springcoredemo.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


public class AutowiringdemoApplication {

	public static void main(String[] args) {

//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
     	TextEditor textEditor = (TextEditor) context.getBean("textEditor");
//		TextEditor textEditorSecondObject = (TextEditor) context.getBean("textEditor");

		System.out.println(textEditor);
		textEditor.spellCheck();
		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
	}

}
