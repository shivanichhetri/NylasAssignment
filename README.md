# NylasAssignment
<H3>1. Retrieve thread_id 4bnil1ikena6s0mwg822bon0p and share your request and the API response.</H3>

<table><td>
        
        Thread thread = account.threads().get("4bnil1ikena6s0mwg822bon0p");
        
</td></table>

<b>Response</b>

<table><td>
        
        Thread [id=4bnil1ikena6s0mwg822bon0p, account_id=c3t3t4u3xv9g42b0gm566yzu9,subject=Nylas challenge - Shivani Chhetri - 2022-05-20, unread=true, starred=false, last_message_timestamp=2022-05-25T02:41:57Z, last_message_received_timestamp=2022-05-20T21:22:30Z, last_message_sent_timestamp=2022-05-25T02:41:59Z, first_message_timestamp=2022-05-20T21:22:11Z, participants=[NameEmail [name=Dominic Jodoin, email=dominic.j@nylas.com], NameEmail [name=dse_challenge nylas, email=nylas.dse.challenge@gmail.com]], snippet=My favourite snack is Cheese Balls., version=30, folders=[], labels=[Label [id=7rq887nrwxc2qqf0r1rxia8bn, name=inbox, display_name=Inbox], Label [id=8voi4244lor13uinu2zjki141, name=sent, display_name=Sent Mail]], has_attachments=false, message_ids=[8wyyvg0odtz7cngguay15mlgw, 1frohy5e8th944ggcn5a6bbgq, bq6jsct3eeq9h6871vwvmr07t, 2hu71diolr3noruy5gz4x3fwl, albvaeh0j8fdlfdbxz7sis63p], draft_ids=[], messages=[], drafts=[]]
      
</td></table>

<h3>2. Provide the subject of each message in the thread above.</h3>

<table><td>

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

        }  
</td></table>

<b>Response</b>

<table><td>
        
           ID: 8wyyvg0odtz7cngguay15mlgw | Subject: Nylas challenge - Shivani Chhetri - 2022-05-20 

           ID: 1frohy5e8th944ggcn5a6bbgq | Subject: Re: Nylas challenge - Shivani Chhetri - 2022-05-20 

           ID: bq6jsct3eeq9h6871vwvmr07t | Subject: Nylas challenge - Shivani Chhetri - 2022-05-20 

           ID: 2hu71diolr3noruy5gz4x3fwl | Subject: Nylas challenge - Shivani Chhetri - 2022-05-20 

           ID: albvaeh0j8fdlfdbxz7sis63p | Subject: Nylas challenge - Shivani Chhetri - 2022-05-20 
</td></table>

<h3>3. What message_ids belong to this thread? Store the message IDs in a variable.</h3>

<table><td>
        
          //get message IDs that belongs to the thread
          List<String> messageIDsList = thread.getMessageIds();
        
</td></table>

<b>Response</b>

<table><td>
  
        [8wyyvg0odtz7cngguay15mlgw, 1frohy5e8th944ggcn5a6bbgq, bq6jsct3eeq9h6871vwvmr07t, 2hu71diolr3noruy5gz4x3fwl, albvaeh0j8fdlfdbxz7sis63p]
  
</td></table>

<h3>4. Use the message_ids from the thread object and retrieve all message objects from the API.</h3>

<table><td>
        
        //get message IDs that belongs to the thread
        List<String> messageIDsList = thread.getMessageIds();

        for (String messageID : messageIDsList) {

            Message message = account.messages().get(messageID);

            //displays all message objects
            //System.out.println("\n" + message + "\n\n");

            //marks messages as read
            //if set false, the result shows unread=true and vice-versa
            account.messages().setUnread(messageID, true);

        }     
</td></table>

<b>Response</b>

<table><td>
        
        Message [id=8wyyvg0odtz7cngguay15mlgw, account_id=c3t3t4u3xv9g42b0gm566yzu9, thread_id=4bnil1ikena6s0mwg822bon0p, subject=Nylas challenge - Shivani Chhetri - 2022-05-20, from=[NameEmail [name=Dominic Jodoin, email=dominic.j@nylas.com]], to=[NameEmail [name=, email=nylas.dse.challenge@gmail.com]], cc=[], bcc=[], reply_to=[], date=2022-05-20T21:22:11Z, unread=true, starred=false, snippet=Hey there! Please make a request to the Nylas API that marks every message in this thread as "read" and be sure to include all requests and responses made. Regards, -- Dominic., body.length=394, files=[], events=[], folder=null, labels=[Label [id=7rq887nrwxc2qqf0r1rxia8bn, name=inbox, display_name=Inbox]], headers={}, metadata={}]

        Message [id=1frohy5e8th944ggcn5a6bbgq, account_id=c3t3t4u3xv9g42b0gm566yzu9, thread_id=4bnil1ikena6s0mwg822bon0p, subject=Re: Nylas challenge - Shivani Chhetri - 2022-05-20, from=[NameEmail [name=Dominic Jodoin, email=dominic.j@nylas.com]], to=[NameEmail [name=, email=nylas.dse.challenge@gmail.com]], cc=[], bcc=[], reply_to=[], date=2022-05-20T21:22:30Z, unread=true, starred=false, snippet=Hello, Please reply to the sender of this message with your favorite snack in the body. Regards, -- Dominic., body.length=217, files=[], events=[], folder=null, labels=[Label [id=7rq887nrwxc2qqf0r1rxia8bn, name=inbox, display_name=Inbox]], headers={}, metadata={}]

        Message [id=bq6jsct3eeq9h6871vwvmr07t, account_id=c3t3t4u3xv9g42b0gm566yzu9, thread_id=4bnil1ikena6s0mwg822bon0p, subject=Nylas challenge - Shivani Chhetri - 2022-05-20, from=[NameEmail [name=dse_challenge nylas, email=nylas.dse.challenge@gmail.com]], to=[NameEmail [name=Dominic Jodoin, email=dominic.j@nylas.com]], cc=[], bcc=[], reply_to=[], date=2022-05-25T02:24:23Z, unread=true, starred=false, snippet=My favourite snack is Cheese Balls., body.length=35, files=[], events=[], folder=null, labels=[Label [id=8voi4244lor13uinu2zjki141, name=sent, display_name=Sent Mail]], headers={}, metadata={}]

        Message [id=2hu71diolr3noruy5gz4x3fwl, account_id=c3t3t4u3xv9g42b0gm566yzu9, thread_id=4bnil1ikena6s0mwg822bon0p, subject=Nylas challenge - Shivani Chhetri - 2022-05-20, from=[NameEmail [name=dse_challenge nylas, email=nylas.dse.challenge@gmail.com]], to=[NameEmail [name=Dominic Jodoin, email=dominic.j@nylas.com]], cc=[], bcc=[], reply_to=[], date=2022-05-25T02:25:01Z, unread=true, starred=false, snippet=My favourite snack is Cheese Balls., body.length=35, files=[], events=[], folder=null, labels=[Label [id=8voi4244lor13uinu2zjki141, name=sent, display_name=Sent Mail]], headers={}, metadata={}]

        Message [id=albvaeh0j8fdlfdbxz7sis63p, account_id=c3t3t4u3xv9g42b0gm566yzu9, thread_id=4bnil1ikena6s0mwg822bon0p, subject=Nylas challenge - Shivani Chhetri - 2022-05-20, from=[NameEmail [name=dse_challenge nylas, email=nylas.dse.challenge@gmail.com]], to=[NameEmail [name=Dominic Jodoin, email=dominic.j@nylas.com]], cc=[], bcc=[], reply_to=[], date=2022-05-25T02:41:59Z, unread=true, starred=false, snippet=My favourite snack is Cheese Balls., body.length=35, files=[], events=[], folder=null, labels=[Label [id=8voi4244lor13uinu2zjki141, name=sent, display_name=Sent Mail]], headers={}, metadata={}]  
        
</td></table>

<h3>
5. Make a request to get the labels available in this account, and add the "Interviews" label to the thread object.
    a. This label already exists. Please do not create a new one. 
</h3>
  
<table><td>
        
        //requests to get the labels in the thread
        List<Label> labelsList = thread.getLabels();
        
        //adds interview label to the object if it doesn't exist
        if(!labelsList.contains(new Label("Interviews"))){
            Label newlabel = new Label("Interviews");
            labelsList.add(newlabel);
        }  
        
</td></table>

<b> Response </b>

Before
<table><td>
        
        [Label [id=8voi4244lor13uinu2zjki141, name=sent, display_name=Sent Mail], Label [id=7rq887nrwxc2qqf0r1rxia8bn, name=inbox, display_name=Inbox]]  
        
</td></table>

After
<table><td>
        
        [Label [id=8voi4244lor13uinu2zjki141, name=sent, display_name=Sent Mail], Label [id=7rq887nrwxc2qqf0r1rxia8bn, name=inbox, display_name=Inbox], Label [id=null, name=null, display_name=Interviews]]
        
</td></table>

<h3>6. Follow the instructions listed in the body of each of the messages.</h3>
Instruction mentioned were

a. Make a request to the Nylas API that marks every message in this thread as "read" and be sure to include all requests and responses made.

<table><td>
        
            //marks messages as read
            //if set false, the result shows unread=true and vice-versa
            account.messages().setUnread(messageID, true);
        
</td></table>

<b> Response </b>

Before
<table><td>

           ID: 8wyyvg0odtz7cngguay15mlgw | Subject: Nylas challenge - Shivani Chhetri - 2022-05-20 
         | Unread: true 

         ID: 1frohy5e8th944ggcn5a6bbgq | Subject: Re: Nylas challenge - Shivani Chhetri - 2022-05-20 
         | Unread: true 

         ID: bq6jsct3eeq9h6871vwvmr07t | Subject: Nylas challenge - Shivani Chhetri - 2022-05-20 
         | Unread: true 

         ID: 2hu71diolr3noruy5gz4x3fwl | Subject: Nylas challenge - Shivani Chhetri - 2022-05-20 
         | Unread: true 

         ID: albvaeh0j8fdlfdbxz7sis63p | Subject: Nylas challenge - Shivani Chhetri - 2022-05-20 
         | Unread: true
  
</td></table>

After
<table><td>
        
           ID: 8wyyvg0odtz7cngguay15mlgw | Subject: Nylas challenge - Shivani Chhetri - 2022-05-20 
         | Unread: false 

         ID: 1frohy5e8th944ggcn5a6bbgq | Subject: Re: Nylas challenge - Shivani Chhetri - 2022-05-20 
         | Unread: false 

         ID: bq6jsct3eeq9h6871vwvmr07t | Subject: Nylas challenge - Shivani Chhetri - 2022-05-20 
         | Unread: false 

         ID: 2hu71diolr3noruy5gz4x3fwl | Subject: Nylas challenge - Shivani Chhetri - 2022-05-20 
         | Unread: false 

         ID: albvaeh0j8fdlfdbxz7sis63p | Subject: Nylas challenge - Shivani Chhetri - 2022-05-20 
         | Unread: false
  
</td></table>

b. Reply to the sender of this message with your favorite snack in the body.

<table><td>
        
          // Sends a reply to a message in the thread
                Draft reply = thread.createReply();
                Message replyMessage = account.messages().get("1frohy5e8th944ggcn5a6bbgq");
                reply.setTo(replyMessage.getFrom());
                reply.setCc(replyMessage.getCc());
                reply.setBody("My favourite snack is Noodle Salad.");
                account.drafts().send(reply);
</td></table>



