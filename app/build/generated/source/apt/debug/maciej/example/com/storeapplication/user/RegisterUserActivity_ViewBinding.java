// Generated code from Butter Knife. Do not modify!
package maciej.example.com.storeapplication.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import maciej.example.com.storeapplication.R;

public class RegisterUserActivity_ViewBinding<T extends RegisterUserActivity> implements Unbinder {
  protected T target;

  private View view2131624108;

  @UiThread
  public RegisterUserActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.button_click, "field 'button' and method 'createUserAccount'");
    target.button = Utils.castView(view, R.id.button_click, "field 'button'", Button.class);
    view2131624108 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.createUserAccount(p0);
      }
    });
    target.lineralLayout = Utils.findRequiredViewAsType(source, R.id.layout, "field 'lineralLayout'", LinearLayout.class);
    target.firstName = Utils.findRequiredViewAsType(source, R.id.firstName, "field 'firstName'", TextInputEditText.class);
    target.lastName = Utils.findRequiredViewAsType(source, R.id.lastName, "field 'lastName'", TextInputEditText.class);
    target.birthDate = Utils.findRequiredViewAsType(source, R.id.birthDate, "field 'birthDate'", TextInputEditText.class);
    target.radioGroup = Utils.findRequiredViewAsType(source, R.id.radioGroup, "field 'radioGroup'", RadioGroup.class);
    target.address = Utils.findRequiredViewAsType(source, R.id.address, "field 'address'", TextInputEditText.class);
    target.country = Utils.findRequiredViewAsType(source, R.id.country, "field 'country'", TextInputEditText.class);
    target.phoneNumber = Utils.findRequiredViewAsType(source, R.id.phoneNumber, "field 'phoneNumber'", TextInputEditText.class);
    target.email = Utils.findRequiredViewAsType(source, R.id.email, "field 'email'", TextInputEditText.class);
    target.password = Utils.findRequiredViewAsType(source, R.id.password, "field 'password'", TextInputEditText.class);
    target.confirmPassword = Utils.findRequiredViewAsType(source, R.id.confirm_password, "field 'confirmPassword'", TextInputEditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.button = null;
    target.lineralLayout = null;
    target.firstName = null;
    target.lastName = null;
    target.birthDate = null;
    target.radioGroup = null;
    target.address = null;
    target.country = null;
    target.phoneNumber = null;
    target.email = null;
    target.password = null;
    target.confirmPassword = null;

    view2131624108.setOnClickListener(null);
    view2131624108 = null;

    this.target = null;
  }
}
