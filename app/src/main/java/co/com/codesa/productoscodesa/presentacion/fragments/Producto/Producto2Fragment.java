package co.com.codesa.productoscodesa.presentacion.fragments.Producto;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.com.codesa.productoscodesa.R;

public class Producto2Fragment extends Fragment implements IProducto2View {

    private OnFragmentProducto2Listener mListener;
    private ProgressDialog progress;

    @Bind(R.id.spTipo)
    Spinner spTipo;

    public Producto2Fragment() {
        // Required empty public constructor
    }

    public static Producto2Fragment newInstance() {
        Producto2Fragment fragment = new Producto2Fragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_producto2, container, false);
        ButterKnife.bind(this, view);

        init();

        return view;
    }

    private void init() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.tipoProductos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipo.setAdapter(adapter);
    }

    @Override
    public void mostrarCargando() {
        progress = ProgressDialog.show(getContext(), "", "Cargando...");
    }

    @Override
    public void ocultarCargando() {
        progress.dismiss();
    }

    @OnClick(R.id.btnFinalizar)
    public void clickFinalizar() {
        if (mListener != null) {
            mListener.finalizar();
        }
    }

    @Override
    public void finalizar() {

    }

    @Override
    public void cargarImagen() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentProducto2Listener) {
            mListener = (OnFragmentProducto2Listener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public interface OnFragmentProducto2Listener {

        void finalizar();
    }
}
