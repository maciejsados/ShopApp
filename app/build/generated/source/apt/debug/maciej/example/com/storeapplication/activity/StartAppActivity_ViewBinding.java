// Generated code from Butter Knife. Do not modify!
package maciej.example.com.storeapplication.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import maciej.example.com.storeapplication.R;

public class StartAppActivity_ViewBinding<T extends StartAppActivity> implements Unbinder {
  protected T target;

  @UiThread
  public StartAppActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.textView = Utils.findRequiredViewAsType(source, R.id.textview_startapp, "field 'textView'", TextView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressbar, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.textView = null;
    target.progressBar = null;

    this.target = null;
  }
}
