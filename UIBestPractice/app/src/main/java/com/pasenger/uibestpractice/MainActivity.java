package com.pasenger.uibestpractice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.pasenger.uibestpractice.adapter.MessageAdapter;
import com.pasenger.uibestpractice.constant.MessageType;
import com.pasenger.uibestpractice.entity.Message;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView msgListView;

    private EditText inputEditText;

    private Button sendBtn;

    private MessageAdapter msgAdapter;

    private List<Message> messageList = new ArrayList<Message>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();

        msgAdapter = new MessageAdapter(MainActivity.this, R.layout.msg_item, messageList);

        inputEditText = (EditText) findViewById(R.id.input_text);
        sendBtn = (Button) findViewById(R.id.send);
        msgListView = (ListView) findViewById(R.id.msg_list_view);

        msgListView.setAdapter(msgAdapter);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputEditText.getText().toString();

                if(!"".equals(content.trim())){
                    Message message = new Message(content, MessageType.SEND.ordinal());

                    //将消息加入消息列表
                    messageList.add(message);

                    //通知adapter listview的数据变化
                    msgAdapter.notifyDataSetChanged();

                    //将消息定位到最后一条
                    msgListView.setSelection(messageList.size());

                    //清空输入框内容
                    inputEditText.setText("");
                }
            }
        });


    }

    private void initDatas(){
        Message message = new Message("Hello guy.", MessageType.RECEIVER.ordinal());
        messageList.add(message);

        Message message1 = new Message("Hello. Who is that?", MessageType.SEND.ordinal());
        messageList.add(message1);

        Message message2 = new Message("This is Tom. Nice talking to you", MessageType.RECEIVER.ordinal());
        messageList.add(message2);

    }
}
