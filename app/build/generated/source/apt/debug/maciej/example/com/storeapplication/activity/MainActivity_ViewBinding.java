// Generated code from Butter Knife. Do not modify!
package maciej.example.com.storeapplication.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import maciej.example.com.storeapplication.R;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  @UiThread
  public MainActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.drawerLayout = Utils.findRequiredViewAsType(source, R.id.drawerLayout, "field 'drawerLayout'", DrawerLayout.class);
    target.navigationView = Utils.findRequiredViewAsType(source, R.id.navigation, "field 'navigationView'", NavigationView.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.product_main_recycler, "field 'recyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.drawerLayout = null;
    target.navigationView = null;
    target.recyclerView = null;

    this.target = null;
  }
}
