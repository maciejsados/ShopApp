// Generated code from Butter Knife. Do not modify!
package maciej.example.com.storeapplication.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import maciej.example.com.storeapplication.R;

public class FruitsActivity_ViewBinding<T extends FruitsActivity> implements Unbinder {
  protected T target;

  @UiThread
  public FruitsActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.products_recycler_view, "field 'recyclerView'", RecyclerView.class);
    target.checkAmountView = Utils.findRequiredViewAsType(source, R.id.checkout_amount, "field 'checkAmountView'", TextView.class);
    target.cartImage = Utils.findRequiredViewAsType(source, R.id.cart_image, "field 'cartImage'", ImageView.class);
    target.goCartButton = Utils.findRequiredViewAsType(source, R.id.goToCartButton, "field 'goCartButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.recyclerView = null;
    target.checkAmountView = null;
    target.cartImage = null;
    target.goCartButton = null;

    this.target = null;
  }
}
