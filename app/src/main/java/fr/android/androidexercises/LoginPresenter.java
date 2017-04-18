package fr.android.androidexercises;

class LoginPresenter {

    private final LoginActivity activity;

    LoginPresenter(LoginActivity activity) {
        this.activity = activity;
    }

    void checkCredentials(String password) {
        if (password != null && password.length() >= 3) {
            activity.logged();
            activity.message(R.string.text_logged);
        } else {
            activity.notLogged();
            activity.message(R.string.notLogged);
        }
    }
}
