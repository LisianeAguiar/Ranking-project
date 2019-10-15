package rankingproject.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class GenerateId {


    public String generateId() {

        return Double.toString(Math.random());
    }
}
