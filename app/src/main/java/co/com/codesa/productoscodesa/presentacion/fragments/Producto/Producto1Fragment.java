package co.com.codesa.productoscodesa.presentacion.fragments.Producto;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.com.codesa.productoscodesa.R;
import co.com.codesa.productoscodesa.presentacion.fragments.DatePickerFragment;
import co.com.codesa.productoscodesa.presentacion.presenters.IProducto1Presenter;
import co.com.codesa.productoscodesa.presentacion.presenters.Producto1Presenter;


public class Producto1Fragment extends Fragment implements
        DatePickerFragment.OnDialogDatePickerFragmentListener, IProducto1View {

    private OnFragmentInteractionListener mListener;
    private final int REQUESTCODE_FECHAVENC = 200;
    private final int REQUESTCODE_FECHAPRD = 300;
    private ProgressDialog progressDialog;
    private IProducto1Presenter producto1Presenter;

    @Bind(R.id.producto1Coordinator)
    CoordinatorLayout coordinatorLayout;

    @Bind(R.id.txtRegistroCodigo)
    EditText txtRegistroCodigo;

    @Bind(R.id.txtRegistroNombre)
    EditText txtRegistroNombre;

    @Bind(R.id.txtFechaVencimiento)
    EditText txtFechaVencimiento;

    @Bind(R.id.txtFechaPrd)
    EditText txtFechaPrd;

    @Bind(R.id.txtDescripcion)
    EditText txtDescripcion;

    public Producto1Fragment() {
        // Required empty public constructor
    }

    public static Producto1Fragment newInstance() {
        Producto1Fragment fragment = new Producto1Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_producto1, container, false);

        ButterKnife.bind(this, view);

        producto1Presenter = new Producto1Presenter(this, getContext());

        initFechas();

        return view;
    }

    private void initFechas() {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        onDateSet(year, month, day, REQUESTCODE_FECHAVENC);
        onDateSet(year, month, day, REQUESTCODE_FECHAPRD);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @OnClick(R.id.btnCalendarFechaVenc)
    public void showCalendarVenc() {
        producto1Presenter.mostrarDatePicker(REQUESTCODE_FECHAVENC);
    }

    @OnClick(R.id.btnCalendarFechaPrd)
    public void showCalendarPrd() {
        producto1Presenter.mostrarDatePicker(REQUESTCODE_FECHAPRD);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDateSet(int year, int monthOfYear, int dayOfMonth, int requestCode) {

        if (requestCode == REQUESTCODE_FECHAVENC) {
            txtFechaVencimiento.setText(String.valueOf(dayOfMonth) + "-" + String.valueOf(monthOfYear)
                    + "-" + String.valueOf(year));
        }

        if (requestCode == REQUESTCODE_FECHAPRD) {
            txtFechaPrd.setText(String.valueOf(dayOfMonth) + "-" + String.valueOf(monthOfYear)
                    + "-" + String.valueOf(year));
        }

    }

    @Override
    public void mostrarCargando() {
        progressDialog = ProgressDialog.show(getContext(), "", "Cargando...");
    }

    @Override
    public void ocultarCargando() {
        progressDialog.dismiss();
    }

    @Override
    public void mostrarDatePicker(int requestCode) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setCallback(this, requestCode);
        fragment.show(getActivity().getSupportFragmentManager(), "datePicker");
    }

    @OnClick(R.id.btnSiguienteProducto1)
    @Override
    public void clickSgte() {
        producto1Presenter.sgte(txtRegistroCodigo.getText().toString(), txtRegistroNombre.getText().toString(),
                txtFechaVencimiento.getText().toString(), txtFechaPrd.getText().toString(),
                txtDescripcion.getText().toString());
    }

    @Override
    public void irAProducto2() {
        mListener.onClickNext();
    }

    @Override
    public void mostrarFaltaIngresoDatos(String mensaje) {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, mensaje, Snackbar.LENGTH_SHORT);
        snackbar.setActionTextColor(Color.RED);
        snackbar.show();
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onClickNext();
    }
}
