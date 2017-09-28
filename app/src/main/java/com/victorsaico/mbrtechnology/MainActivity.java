package com.victorsaico.mbrtechnology;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.victorsaico.mbrtechnology.fragments.AnadirTicket;
import com.victorsaico.mbrtechnology.fragments.AsignarTickets;
import com.victorsaico.mbrtechnology.fragments.AtenderTickets;
import com.victorsaico.mbrtechnology.fragments.ConsultarTicketsAsignados;
import com.victorsaico.mbrtechnology.fragments.ConsultarTodosTickets;
import com.victorsaico.mbrtechnology.fragments.EstadoTickets;
import com.victorsaico.mbrtechnology.fragments.Perfil;
import com.victorsaico.mbrtechnology.fragments.ReporteTodoTickets;
import com.victorsaico.mbrtechnology.repositorys.UsuarioRepository;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private String rol,rol1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomNavigationView);

        final Fragment anadirticket = new AnadirTicket();
        final Fragment asignartickets = new AsignarTickets();
        final Fragment atendertickets = new AtenderTickets();
        final Fragment consultarticketsasignados = new ConsultarTicketsAsignados();
        final Fragment consultartodostickets = new ConsultarTodosTickets();
        final Fragment estadotickets = new EstadoTickets();
        final Fragment pefil = new Perfil();
        final Fragment reportetodotickets = new ReporteTodoTickets();

        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer, anadirticket).commit();
        }

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();

                if (item.getItemId() == R.id.anadirticket) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, anadirticket).commit();
                } else if (item.getItemId() == R.id.asignariconos) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, asignartickets).commit();
                } else if (item.getItemId() == R.id.atenderticket) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, atendertickets).commit();
                } else if (item.getItemId() == R.id.consultarticketsasignados) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, consultarticketsasignados).commit();
                } else if (item.getItemId() == R.id.consultartodostickets) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, consultartodostickets).commit();
                } else if (item.getItemId() == R.id.estadotickets){
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, estadotickets).commit();
                } else if (item.getItemId() == R.id.perfil){
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, reportetodotickets).commit();
                }

            }
        });

        Intent intent = getIntent();
        rol = intent.getStringExtra("rol");
        RecibirRol();
        Toast.makeText(this, rol1, Toast.LENGTH_SHORT).show();
        switch (rol1){
            case "cliente":
                bottomNavigationView.getMenu().removeItem(R.id.asignariconos);
                bottomNavigationView.getMenu().removeItem(R.id.atenderticket);
                break;
            case "supervisor":
                bottomNavigationView.getMenu().removeItem(R.id.anadirticket);
                bottomNavigationView.getMenu().removeItem(R.id.estadotickets);
                bottomNavigationView.getMenu().removeItem(R.id.atenderticket);
                bottomNavigationView.getMenu().add(0, R.id.consultartodostickets, 1,"Consultar Todos Tickets");
                bottomNavigationView.getMenu().findItem(R.id.consultartodostickets).setIcon(R.drawable.ic_consultartodostickets);
                bottomNavigationView.getMenu().add(0, R.id.reportetodotickets , 1, "Reporte de tickets");
                bottomNavigationView.getMenu().findItem(R.id.reportetodotickets).setIcon(R.drawable.ic_reporttickets);
                break;
            case "tecnico":
                bottomNavigationView.getMenu().removeItem(R.id.anadirticket);
                bottomNavigationView.getMenu().removeItem(R.id.estadotickets);
                bottomNavigationView.getMenu().removeItem(R.id.asignariconos);
                bottomNavigationView.getMenu().add(0, R.id.consultarticketsasignados, 1, "Tickets Asignados");
                bottomNavigationView.getMenu().findItem(R.id.consultarticketsasignados).setIcon(R.drawable.ic_reporttickets);
                break;
        }
    }
    public void RecibirRol(){
        UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();
        rol1 = usuarioRepository.Asignar(rol);
    }
}
