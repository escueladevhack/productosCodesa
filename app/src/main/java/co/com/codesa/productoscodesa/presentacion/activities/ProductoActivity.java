package co.com.codesa.productoscodesa.presentacion.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.Bind;
import co.com.codesa.productoscodesa.R;
import co.com.codesa.productoscodesa.presentacion.fragments.Producto.Producto1Fragment;
import co.com.codesa.productoscodesa.presentacion.fragments.Producto.Producto2Fragment;

public class ProductoActivity extends AppCompatActivity implements
        Producto1Fragment.OnFragmentInteractionListener,
        Producto2Fragment.OnFragmentProducto2Listener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        init();
    }

    private void init() {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_producto, new Producto1Fragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_nuevo:
                break;
            case R.id.menu_acerca:
                break;
            default:
                return true;
        }

        return true;
    }

    @Override
    public void onClickNext() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_producto, new Producto2Fragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void finalizar() {

    }
}
