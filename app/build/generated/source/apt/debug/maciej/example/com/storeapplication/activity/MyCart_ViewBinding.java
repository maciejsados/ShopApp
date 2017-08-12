// Generated code from Butter Knife. Do not modify!
package maciej.example.com.storeapplication.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import maciej.example.com.storeapplication.R;

public class MyCart_ViewBinding<T extends MyCart> implements Unbinder {
  protected T target;

  @UiThread
  public MyCart_ViewBinding(T target, View source) {
    this.target = target;

    target.button = Utils.findRequiredViewAsType(source, R.id.my_cart_go_store_button, "field 'button'", Button.class);
    target.buton_back = Utils.findRequiredViewAsType(source, R.id.back_to_main, "field 'buton_back'", Button.class);
    target.listView = Utils.findRequiredViewAsType(source, R.id.list_cart, "field 'listView'", ListView.class);
    target.textView = Utils.findRequiredViewAsType(source, R.id.text_cart, "field 'textView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.button = null;
    target.buton_back = null;
    target.listView = null;
    target.textView = null;

    this.target = null;
  }
}
