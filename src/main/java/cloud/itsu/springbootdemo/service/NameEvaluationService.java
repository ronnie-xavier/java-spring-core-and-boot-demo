package cloud.itsu.springbootdemo.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class NameEvaluationService {

    public String evaluateName (String name) {
        if (StringUtils.isEmpty(name)) {
            return "Was an Empty String";
        } else {
            switch (name.charAt(0)) {
                case 'R' : return "The name starts with R " + name;
                case 'A' : return "The name starts with A " + name;
                default : return "The name does not start with A or R " + name;
            }
        }
    }
}
