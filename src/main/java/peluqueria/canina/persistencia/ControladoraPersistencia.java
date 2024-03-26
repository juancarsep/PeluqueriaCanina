package peluqueria.canina.persistencia;

import peluqueria.canina.logica.Duenio;
import peluqueria.canina.logica.Mascota;

public class ControladoraPersistencia {
DuenioJpaController duenioJpa = new DuenioJpaController();
MascotaJpaController mascotaJpa = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota masco) {
        duenioJpa.create(duenio);
        mascotaJpa.create(masco);
    }
    
    
}
