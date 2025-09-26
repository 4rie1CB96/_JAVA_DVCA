import java.time.LocalDate;

public class Agenda {
    private String nombre;
    private int hora;
    private LocalDate fechas;

    public Agenda(LocalDate fechas, int hora, String nombre) {
        this.fechas = fechas;
        this.hora = hora;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHora() {
        return hora;
    }

    public LocalDate getFechas() {
        return fechas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setFechas(LocalDate fechas) {
        this.fechas = fechas;
    }

    @Override
    public String toString() {
        return "Agenda [nombre=" + nombre + ", hora=" + hora + ", fechas=" + fechas + "]";
    }

}