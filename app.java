public class app
{
    public static void main(String[] args)
    {
        Automaton automaton = new Automaton("file.txt");
        System.out.println(automaton.toString());
    }
}
