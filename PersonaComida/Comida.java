
/**
 * Write a description of class Comida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Comida
{
    private int caloriasComida;

    /**
     * El constructor de la clase Comida deberá tener (en el mismo orden):

     * Un parámetro que permita indicar el nombre de la comida.
     * Un parámetro entero que permita indicar la cantidad de calorias asociadas a la comida.
     */
    public Comida(String nombreComida,int calorias)
    {
       caloriasComida = calorias;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getCalorias()
    {
        return caloriasComida;
    }
}
