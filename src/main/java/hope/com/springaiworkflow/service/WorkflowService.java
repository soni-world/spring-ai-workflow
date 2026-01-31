package hope.com.springaiworkflow.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class WorkflowService {

    ChatClient chatClient;

    public WorkflowService(ChatClient.Builder chatClientBuilder){
        this.chatClient = chatClientBuilder.build();
    }

    String[] workFlowSteps = {
            "Summarize the following text in 1-2 sentences.",
            "Extract 3-4 key points from text as bullet points.",
            "Generate 3 thoughtful follow-uo questions."
    };

    public String chain(String userInput) {
        String response = userInput;

        for(String prompt : workFlowSteps){
            String input = String.format("%s\n\nText: %s", prompt, response);
            response = chatClient.prompt(input)
                    .call()
                    .content();
            System.out.println(response);
        }

        return response;
    }

}
