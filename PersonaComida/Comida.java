
/**
 * Write a description of class Comida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Comida
{
    private int caloriasComida;
	private String nombreComida;

    /**
     * El constructor de la clase Comida deberá tener (en el mismo orden):

     * Un parámetro que permita indicar el nombre de la comida.
     * Un parámetro entero que permita indicar la cantidad de calorias asociadas a la comida.
     */
    public Comida(String nombre,int calorias)
    {
	   nombreComida = nombre;
       caloriasComida = calorias;
    }

    /**
	 *Devuelve las calorias
     */
    public int getCalorias()
    {
        return caloriasComida;
    }

    /**
	 *Devuelve el nombre
     */
    public String getNombre()
    {
        return nombreComida;
    }
}
