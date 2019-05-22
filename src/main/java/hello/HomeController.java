package hello;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private final JmsTemplate jmsTemplate;

    public HomeController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @RequestMapping("/send")
    @ResponseBody
    public String sendAction(){

        System.out.println("Sending an email message.");
        jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", RandomStringUtils.randomAlphabetic(10)));

        return "send";
    }
}
