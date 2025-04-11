package ed_ex6_javadocs;
/**
 * @author CádizTech
 * @version 2.4.0 del software
 * @see Referencia a https://institucional.cadiz.es/area/Plan-de-Movilidad-Urbana-Sostenible/2021 
 * 
 */

/**
 * Importamos lo necesario
 */
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Creamos la Clase CarrilBiciManager.
 */
public class CarrilBiciManager {

    /** Los tramos. */
    private final Map<String, Double> tramos; // nombre del tramo -> longitud en km
    
    /** El estado tramos */
    private final Map<String, String> estadoTramos; // nombre del tramo -> estado

    /**
     * Nuevo carril bici
     */
    public CarrilBiciManager() {
        this.tramos = new HashMap<>();
        this.estadoTramos = new HashMap<>();
    }

    /**
     * Añadiremos los tramos
     *
     * @param nombre de nombre
     * @param longitud de longitud
     */
    public void añadirTramo(String nombre, double longitud) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del tramo no puede estar vacío");
        }
        if (longitud <= 0) {
            throw new IllegalArgumentException("La longitud debe ser mayor que cero");
        }
        tramos.put(nombre, longitud);
        estadoTramos.put(nombre, "En servicio");
    }

    /**
     * Actualizaremos el estado
     *
     * @param nombre de nombre
     * @param nuevoEstado de nuevo estado
     */
    
    
    public void actualizarEstado(String nombre, String nuevoEstado) {
        if (!tramos.containsKey(nombre)) {
            throw new NoSuchElementException("El tramo indicado no existe: " + nombre);
        }
        estadoTramos.put(nombre, nuevoEstado);
    }
    
    /**
     * Cambiar estado.
     *
     * @param nombre the nombre
     * @param estado the estado
     */
    
    /**
     * No funciona el metodo correctamente por lo que sería interesante que se deje de usar y se empiece a utilizar el “public void actualizarEstado(String nombre, String nuevoEstado)”.     
     * 
     * @exception Usar el metodo actualizarEstado
     */
    public void cambiarEstado(String nombre, String estado) {
        actualizarEstado(nombre, estado);
    }

    /**
     * Consultar estado.		
     *
     * @param nombre de nombre
     * @return el string
     */
    public String consultarEstado(String nombre) {
        if (!estadoTramos.containsKey(nombre)) {
            throw new NoSuchElementException("El tramo indicado no existe");
        }
        return estadoTramos.get(nombre);
    }

    /**
     * Longitud total.
     *
     * @return el double 
     */
    public double longitudTotal() {
        return tramos.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    /**
     * Aqui obtenemos los tramos
     *
     * @return el map 
     */
    public Map<String, Double> obtenerTramos() {
        return Collections.unmodifiableMap(tramos);
    }

    
    /**
     * Generaramos el informe , devolviendo el resultado
     *
     * @return el string
     */
    public String generarInforme() {
        StringBuilder sb = new StringBuilder("INFORME DE CARRILES BICI - Bahía de Cádiz\n");
        sb.append("===========================================\n");
        for (String nombre : tramos.keySet()) {
            sb.append("- ").append(nombre).append(" (")
              .append(tramos.get(nombre)).append(" km): ")
              .append(estadoTramos.get(nombre)).append("\n");
        }
        sb.append("Longitud total: ").append(longitudTotal()).append(" km\n");
        return sb.toString();
    }
}
