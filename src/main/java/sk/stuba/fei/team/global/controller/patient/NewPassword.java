package sk.stuba.fei.team.global.controller.patient;

/**
 * Created by jakubrehak on 17/06/15.
 */
public class NewPassword {
    private String oldPassword;
    private String newPassword;
    private String newPasswordAgain;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordAgain() {
        return newPasswordAgain;
    }

    public void setNewPasswordAgain(String newPasswordAgain) {
        this.newPasswordAgain = newPasswordAgain;
    }
}
