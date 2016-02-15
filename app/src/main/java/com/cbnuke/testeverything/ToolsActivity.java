package com.cbnuke.testeverything;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cbnuke.testeverything.apimodel.ApiLogin;
import com.cbnuke.testeverything.apimodel.ApiStatus;

/**
 * Created by cbnuke on 2/15/16.
 */
public class ToolsActivity extends Fragment implements View.OnClickListener {
    ApiConnect apiConnect = new ApiConnect();

    EditText txtUser, txtPass;
    Button btnLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tools_main, container, false);
        txtUser = (EditText) rootView.findViewById(R.id.txtUser);
        txtPass = (EditText) rootView.findViewById(R.id.txtPass);
        btnLogin = (Button) rootView.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin) {
            Toast.makeText(getContext(), "" + txtUser.getText() + "||" + txtPass.getText(), Toast.LENGTH_LONG).show();

            String user = "" + txtUser.getText();
            String pass = "" + txtPass.getText();
            ApiLogin apiLogin = new ApiLogin(user, pass);
            connect connect = new connect();
            connect.execute(apiLogin);

        }

    }

    class connect extends AsyncTask<ApiLogin, Void, ApiStatus> {

        @Override
        protected ApiStatus doInBackground(ApiLogin... params) {
            return apiConnect.login(params[0]);
        }

        @Override
        protected void onPostExecute(ApiStatus apiStatus) {
            super.onPostExecute(apiStatus);

            txtUser.setText(apiStatus.getStatus());
        }
    }
}
