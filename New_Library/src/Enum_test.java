//Esta madre es una lista de valores los cuales una vez ejecutado el programa, ya no pueden ser cambiados
//Se comportan muy similarmente a los objetos

//Un enum es una lista de valores que pueden contener atributos al especificarlos con un constructor, se accede a estos valores mediante:
// nombre_enum nombre_x = nombre_enum.valor_enum;
// Para acceder a los atributos:
//      "       "       = nombre_enum.valor_enum.nombre_atributo;
public enum Enum_test {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    final int dayNumber; //Declarar final los atrbituos de los valores hace que sea imposible cambiar estos durante la ejecución del programa

    Enum_test(int number){
        this.dayNumber = number;
    }
}