package shivani;

import java.io.IOException;
import java.util.List;

import com.nylas.Draft;
import com.nylas.Label;
import com.nylas.Message;
import com.nylas.NylasAccount;
import com.nylas.NylasClient;
import com.nylas.RequestFailedException;
import com.nylas.Thread;

import okhttp3.OkHttpClient;

import com.nylas.HttpLoggingInterceptor;

public class NylasAssignment {
    public static void main(String[] args) throws IOException, RequestFailedException {
        
        //connecting to Nylas SDK
        //provide account's access token
        NylasClient client = new NylasClient();
        NylasAccount account = client.account("2G92spEQ2yT4vKfHRn2bPUfD6esjqg");


        //retrieves thread id=4bnil1ikena6s0mwg822bon0p
        Thread thread = account.threads().get("4bnil1ikena6s0mwg822bon0p");

        //get message IDs that belongs to the thread
        List<String> messageIDsList = thread.getMessageIds();


        //display message IDs stored in a variable that belongs to the thread
        System.out.println(messageIDsList);

        for (String messageID : messageIDsList) {

            Message message = account.messages().get(messageID);

            //displays subjects of each messages in the thread
            System.out.printf( "\n ID: %s | Subject: %s \n",
                message.getId(),
                message.getSubject()
                );

            //displays all message objects
            System.out.println("\n" + message + "\n\n");

            //marks messages as read
            //if set false, the result shows unread=true and vice-versa
            account.messages().setUnread(messageID, true);

        }   

        //requests to get the labels in the thread
        List<Label> labelsList = thread.getLabels();
        
        //adds interview label to the object if it doesn't exist
        if(!labelsList.contains(new Label("Interviews"))){
            Label newlabel = new Label("Interviews");
            labelsList.add(newlabel);
        }

        // Sends a reply to a message in the thread
        Draft reply = thread.createReply();
        Message replyMessage = account.messages().get("1frohy5e8th944ggcn5a6bbgq");
        reply.setTo(replyMessage.getFrom());
        reply.setCc(replyMessage.getCc());
        reply.setBody("My favourite snack is Noodle Salad.");
        //account.drafts().send(reply);

    }
}
