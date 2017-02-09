import java.util.ArrayList;
/**
 * Diseña una clase Persona que simule una persona y una clase Comida que simule una comida. Ejemplos de comidas serían paella, arroz blanco, macarrones, pollo asado, lentejas, etc. 
 * Cada comida se carcateriza por un nombre y por la cantidad de calorias que posee (sin decimales).
 */
public class Persona
{
    private static final int PREGUNTA_DIVISIBLE_ENTRE = 3;  //Lo uso para comprobar si la pregunta pasada es disivisible entre este entero 
   
    private int caloriasIngerida;                           //Calorias tomadas.
    private int maximoCaloriasQuePuedeIngerir;              //Máximo calorias que puede tomar
    private String nombrePersona;                           //Guarda el nombre de la persona;
	private ArrayList<Comida> comidaTomada;					//Es un arraylist que guarda las comidas tomadas;
	private Comida comidaMasCaloricaTomada;					//Nos dice cual es la comida tomada mas calórica
   
    /**
     * El constructor de la clase Persona deberá tener (en el mismo orden):
     * Un parámetro que permita indicar el nombre de la persona.
     * Un parámetro booleano que permita indicar si la persona es un hombre.
     * Un parámetro entero que permita indicar el peso en kilogramos de la persona.
     * Un parámetro entero que permita indicar la altura en centímetros de la persona.
     * Un parámetro entero que permita indicar la edad en años de la persona.
     */
    public Persona(String nombre, boolean sexo, int peso, int altura, int edad)
    {
        caloriasIngerida = 0;
        nombrePersona = nombre;
		comidaTomada = new ArrayList<Comida>();
		comidaMasCaloricaTomada = null;
        
        if(sexo){
            maximoCaloriasQuePuedeIngerir = (10 * peso) + (6 * altura) + (5 * edad) + 5;        //Calcula la cantidad de calorias que puede tomar si es hombre
        }
        else{
            maximoCaloriasQuePuedeIngerir = (10 * peso) + (6 * altura) + (5 * edad) - 161;       //Calcula la cantidad de calorias que puede tomar si es mujer
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
		if(comidaMasCaloricaTomada == null){
			comidaMasCaloricaTomada = nombreComida;
		}
        if(caloriasIngerida <= maximoCaloriasQuePuedeIngerir){   //Compruebo que las calorias que le mandan tomar no supere el máximo de calorias que puede tomar.
            caloriasPorComida = nombreComida.getCalorias();
            caloriasIngerida = caloriasIngerida + caloriasPorComida;
			comidaTomada.add(nombreComida);
			if(comidaMasCaloricaTomada.getCalorias() < nombreComida.getCalorias()){
				comidaMasCaloricaTomada = nombreComida;
			}
		}
        return caloriasPorComida;
    }
    
    /**
     * El método que permite saber la cantidad de calorias que lleva ingerida una persona se denomina getCaloriasIngeridas, no admite parámetros y devuelve un entero.
     */
    public int getCaloriasIngeridas(){
        return caloriasIngerida;
    }
    
    /**
     *Ahora queremos que sea posible preguntarle cosas a la persona. Si no ha sobrepasado su metabolismo basal, te contestará "SI" o "NO" (¡en mayúsculas!) 
     *dependiendo de si la pregunta tiene una longitud (es decir, el número de letras de la misma) divisible por 3 o no, respectivamente.
     *En caso de que la persona ya haya sobrepasado el metabolismo basal o en el caso de que tu pregunta contenga el nombre de la persona, responderá con la misma pregunta que le has hecho pero gritando 
     *(es decir, el mismo texto de la pregunta pero en mayúsculas) indiferentemente de la longitud de a pregunta.
     *El método que se utiliza para preguntar cosas a la persona debe llamarse contestar, admite un único parámetro y debe devolver la respuesta además de imprimirla por pantalla.
     */
    public String contestar(String pregunta){
		String devuelve = "";
        System.out.println(pregunta);
        
        if(caloriasIngerida <= maximoCaloriasQuePuedeIngerir && !pregunta.contains(nombrePersona)){  	
            if((pregunta.length() % PREGUNTA_DIVISIBLE_ENTRE) == 0){
                System.out.println("SI");
				devuelve = "SI";
            }
            else{
                System.out.println("NO");
				devuelve = "NO";
            }
        }
        else{
               System.out.println(pregunta.toUpperCase());
			   devuelve = pregunta.toUpperCase();
            }       
   		return devuelve;
    }

    /**
     * Se pide que implementes el código necesario para disponer de un método llamado getAlimentoMasCaloricoConsumido que imprima por pantalla y que devuelva el nombre de la comida más calórico ingerida hasta ahora por un usuario.
	 * En caso de que la persona no haya comido nada el método infoma por pantalla de tal situación y devuelve null. En caso de que haya empate entre dos o más comidas, imprime y devuelve la última de ellas.
     */
    public String getAlimentoMasCaloricoConsumido (){
		String respuesta = null;

		if(comidaTomada.size() == 0){
			System.out.println("No ha comido nada");
		  }
		else{
			respuesta = comidaMasCaloricaTomada.getNombre();
		}

		for(int contador = 0; contador < comidaTomada.size(); contador++){
			System.out.println(comidaTomada.get(contador));
			}
        return respuesta;
    }
}

