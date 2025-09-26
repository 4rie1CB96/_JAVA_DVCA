/*## 2. **Lista de Tareas (Java + POO)**

- **Qué practican:** clases, objetos, `ArrayList`.
- **Descripción:** Crear un programa que permita:
    - Agregar tareas pendientes (con nombre y estado: pendiente/completada).
    - Mostrar todas las tareas.
    - Marcar una tarea como completada.
- **Extras:** Guardar también la fecha límite de cada tarea. */


public class Tareas {
	//Variables
	String nombre;
	boolean estado;
	String fechaLimite;

    public Tareas(String fechaLimite, String nombre) {
        this.estado = false; //Siempre empieza como pendiente
        this.fechaLimite = fechaLimite;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tareas{");
        sb.append("nombre=").append(nombre);
        sb.append(", estado=").append(estado);
        sb.append(", fechaLimite=").append(fechaLimite);
        sb.append('}');
        return sb.toString();
    }

	 
}
