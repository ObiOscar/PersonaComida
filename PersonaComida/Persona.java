
/**
 * Diseña una clase Persona que simule una persona y una clase Comida que simule una comida. Ejemplos de comidas serían paella, arroz blanco, macarrones, pollo asado, lentejas, etc. 
 * Cada comida se carcateriza por un nombre y por la cantidad de calorias que posee (sin decimales).
 */
public class Persona
{
    private int caloriasIngerida;                //Calorias tomadas.
    private int maximoCaloriasQuePuedeIngerir;   //Máximo calorias que puede tomar
    

    /**
     * El constructor de la clase Persona deberá tener (en el mismo orden):
     * Un parámetro que permita indicar el nombre de la persona.
     * Un parámetro booleano que permita indicar si la persona es un hombre.
     * Un parámetro entero que permita indicar el peso en kilogramos de la persona.
     * Un parámetro entero que permita indicar la altura en centímetros de la persona.
     * Un parámetro entero que permita indicar la edad en años de la persona.
     */
    public Persona(String nombrePersona, boolean sexo, int peso, int altura, int edad)
    {
        caloriasIngerida = 0;
        
        if(sexo){
            maximoCaloriasQuePuedeIngerir = (10 * peso) + (6 * altura) - (5 * edad) + 5;        //Calcula la cantidad de calorias que puede tomar si es hombre
        }
        else{
            maximoCaloriasQuePuedeIngerir = (10 * peso) + (6 * altura) - (5 * edad) - 161;       //Calcula la cantidad de calorias que puede tomar si es mujer
        }
    }

    /**
     * El metódo que se utiliza para dar de comer a la persona debe denominarse comer, debe permitir 1 único parámetro de tipo comida y debe devolver un entero 
     * consistente en las calorias ingeridas en esa comida en caso de que la persona la coma o -1 en caso de que no la coma.
     * El método que permite saber la cantidad de calorias que lleva ingerida una persona se denomina getCaloriasIngeridas, no admite parámetros y devuelve un entero.
     */
    public int comer(Comida nombreComida)
    {
        int caloriasPorComida = -1; 
        if((caloriasIngerida + nombreComida.getCalorias()) <= maximoCaloriasQuePuedeIngerir){   //Compruebo que las calorias que le mandan tomar no supere el máximo de calorias que puede tomar.
            caloriasPorComida = nombreComida.getCalorias();
            caloriasIngerida = caloriasIngerida + caloriasPorComida;
        }
        return caloriasPorComida;
    }
    
    /**
     * El método que permite saber la cantidad de calorias que lleva ingerida una persona se denomina getCaloriasIngeridas, no admite parámetros y devuelve un entero.
     */
    public int getCaloriasIngeridas(){
        return caloriasIngerida;
    }
}
