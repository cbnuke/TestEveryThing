package com.cbnuke.testeverything;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.cbnuke.testeverything.apimodel.ApiRegister;
import com.cbnuke.testeverything.apimodel.ApiStatus;

/**
 * Created by cbnuke on 2/15/16.
 */
public class ShareActivity extends Fragment implements View.OnClickListener {
    ApiConnect apiConnect = new ApiConnect();

    EditText txtEmail, txtPass, txtFirst, txtLast;
    Button btnRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.share_main, container, false);
        txtEmail = (EditText) rootView.findViewById(R.id.txtEmail);
        txtPass = (EditText) rootView.findViewById(R.id.txtPass);
        txtFirst = (EditText) rootView.findViewById(R.id.txtFirst);
        txtLast = (EditText) rootView.findViewById(R.id.txtLast);
        btnRegister = (Button) rootView.findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnRegister) {
            String email = "" + txtEmail.getText();
            String pass = "" + txtPass.getText();
            String first = "" + txtFirst.getText();
            String last = "" + txtLast.getText();

            ApiRegister apiRegister = new ApiRegister(email,pass,first,last);
            connect connect = new connect();
            connect.execute(apiRegister);
        }
    }

    class connect extends AsyncTask<ApiRegister, Void, ApiStatus> {
        @Override
        protected ApiStatus doInBackground(ApiRegister... params) {
            return apiConnect.register(params[0]);
        }

        @Override
        protected void onPostExecute(ApiStatus apiStatus) {
            super.onPostExecute(apiStatus);

            txtEmail.setText(apiStatus.getStatus());
        }
    }
}
