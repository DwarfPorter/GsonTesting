package ru.geekbrains.gsontesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements ViewMainActivity {

    private EditText name;
    private EditText surname;
    private IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initPresenter();
    }

    private void initView(){
        name = findViewById(R.id.editText);
        surname = findViewById(R.id.editText2);
        Button save = findViewById(R.id.button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.save();
            }
        });
    }

    private void initPresenter(){
        IRepository repository = new Repository();
        presenter = new Presenter(this, repository);
    }

    @Override
    public String getName() {
        return name.getText().toString();
    }

    @Override
    public String getSurname() {
        return surname.getText().toString();
    }

    void setPresenter(IPresenter presenter) {
        this.presenter = presenter;
    }
}
