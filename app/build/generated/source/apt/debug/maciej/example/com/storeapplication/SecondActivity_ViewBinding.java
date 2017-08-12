// Generated code from Butter Knife. Do not modify!
package maciej.example.com.storeapplication;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import maciej.example.com.storeapplication.activity.SecondActivity;

import java.lang.IllegalStateException;
import java.lang.Override;

public class SecondActivity_ViewBinding<T extends SecondActivity> implements Unbinder {
  protected T target;

  @UiThread
  public SecondActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.textView = Utils.findRequiredViewAsType(source, R.id.text_view_basket, "field 'textView'", TextView.class);
    target.textView1 = Utils.findRequiredViewAsType(source, R.id.text_view_basket1, "field 'textView1'", TextView.class);
    target.textView2 = Utils.findRequiredViewAsType(source, R.id.text_view_basket2, "field 'textView2'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.textView = null;
    target.textView1 = null;
    target.textView2 = null;

    this.target = null;
  }
}
