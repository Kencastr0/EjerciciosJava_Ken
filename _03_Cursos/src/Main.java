import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner objScan = new Scanner(System.in);
        GestionCurso objGestion = new GestionCurso();

        int option = 0;

        do {
            System.out.println("""
                                        
                    MENÚ DE OPCIONES:
                                        
                    1. Administrar cursos.
                    2. Administrar estudiantes.
                    3. Salir.
                                        
                    """);
            option = objScan.nextInt();
            switch (option) {
                case 1:

                    int option2 = 0;

                    do {
                        System.out.println("""
                                                                
                                MENÚ DE CURSOS:
                                                                
                                1. Crear un curso.
                                2. Buscar curso por código.
                                3. Listar cursos
                                4. Salir
                                                                
                                """);
                        option2 = objScan.nextInt();
                        switch (option2) {

                            case 1:

                                objGestion.guardarCurso(objScan);
                                break;

                            case 2:

                                objGestion.listarCursos();
                                System.out.println("Código del curso: ");
                                String codigo = objScan.next();
                                if (objGestion.buscarPorCodigo(codigo) == null) {
                                    System.out.println("Curso no encontrado");
                                    break;
                                }else {
                                    System.out.println(objGestion.buscarPorCodigo(codigo).toString());
                                    break;
                                }

                            case 3:

                                objGestion.listarCursos();
                                break;
                        }
                    } while (option2 != 4);
                    break;

                case 2:

                    int option3 = 0;

                    do {
                        System.out.println("""
                                                                
                                MENÚ GESTIÓN DE ESTUDIANTES:
                                                                
                                1. Agregar Estudiante.
                                2. Eliminar un Estudiante.
                                3. listar Estudiantes.
                                4. Salir
                                                                
                                """);
                        option3 = objScan.nextInt();

                        switch (option3) {

                            case 1:

                                objGestion.listarCursos();
                                System.out.println("Código del curso donde desea inscribir el estudiante");
                                String codigo = objScan.next();
                                Curso curso = objGestion.buscarPorCodigo(codigo);

                                if (curso == null) {
                                    System.out.println("Class not found");
                                } else {
                                    curso.guardarEstudiante(objScan);
                                }
                                break;

                            case 2: //Caso para eliminar un estudiante
                                //1. listar cursos
                                objGestion.listarCursos();
                                //2. Curso del estudiante a eliminar
                                System.out.println("Código del curso del estudiante a eliminar");
                                codigo = objScan.next();
                                //3. Llamar al método eliminar
                                Curso objCurso = objGestion.buscarPorCodigo(codigo);

                                if (objCurso == null) {
                                    System.out.println("Code invalid");
                                } else {
                                    //Eliminar
                                    objCurso.eliminarEstudiante(objScan);
                                }
                                break;

                            case 3:

                                objGestion.listarCursos();
                                System.out.println("Código del curso para ver lista de estudiantes");
                                codigo = objScan.next();
                                curso = objGestion.buscarPorCodigo(codigo);

                                if (curso == null) {
                                    System.out.println("Class not found");
                                } else {
                                    curso.listarEstudiantes();
                                }
                                break;
                        }
                    } while (option3 != 4);
                    break;
            }
        } while (option != 3);
    }
}