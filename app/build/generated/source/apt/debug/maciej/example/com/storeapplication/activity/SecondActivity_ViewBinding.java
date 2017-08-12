// Generated code from Butter Knife. Do not modify!
package maciej.example.com.storeapplication.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import maciej.example.com.storeapplication.R;

public class SecondActivity_ViewBinding<T extends SecondActivity> implements Unbinder {
  protected T target;

  @UiThread
  public SecondActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.textView_name = Utils.findRequiredViewAsType(source, R.id.product_add_name, "field 'textView_name'", TextView.class);
    target.textView_price = Utils.findRequiredViewAsType(source, R.id.product_add_price, "field 'textView_price'", TextView.class);
    target.textView_quantity = Utils.findRequiredViewAsType(source, R.id.product_add_quantity, "field 'textView_quantity'", TextView.class);
    target.textView_total_price = Utils.findRequiredViewAsType(source, R.id.product_total_price, "field 'textView_total_price'", TextView.class);
    target.addBtn = Utils.findRequiredViewAsType(source, R.id.add_cart_btn, "field 'addBtn'", Button.class);
    target.imageView = Utils.findRequiredViewAsType(source, R.id.pre_cart_view, "field 'imageView'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.textView_name = null;
    target.textView_price = null;
    target.textView_quantity = null;
    target.textView_total_price = null;
    target.addBtn = null;
    target.imageView = null;

    this.target = null;
  }
}
