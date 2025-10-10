package trabs.trab1.grupo2;

public class ExampleGrade {
    public static void main(String[] args) {
//       SG sg = new SG(9, "John", 10);
//        System.out.println(sg);
//        System.out.println(sg.getName() + " is " + (sg.isApproved()? "Approved" : "Reproved"));
//
//        Grade[] seq = { new SG( 9, new Proof("1º Teste", 8) ),
//                new SG( 8,"2º Teste", 8 ) };
//        Grade testes = new AverageGrade( new Proof("Testes", 10), seq );
//        testes.list("");
        try{
            GreaterGrade g = new GreaterGrade(new Proof("Testes", 16),
                    new SG(8, new Exam("Teste 2")));
            System.out.println(g.isApproved());
            g.list("");
        }catch (GradeException e){
            System.out.println(e);
        }
    }
}