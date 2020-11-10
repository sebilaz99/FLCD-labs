import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Automaton
{
    private List<String> statesAlphabet = new ArrayList<>();
    private List<String> initAlphabet = new ArrayList<>();
    private List<Transition> transitionList = new ArrayList<Transition>();
    private String initState;
    private List<String> finalStates = new ArrayList<>();

    public Automaton(){}

    public List<String> getStatesAlphabet() {
        return statesAlphabet;
    }

    public void setStatesAlphabet(List<String> statesAlphabet) {
        this.statesAlphabet = statesAlphabet;
    }

    public List<String> getInitAlphabet() {
        return initAlphabet;
    }

    public void setInitAlphabet(List<String> initAlphabet) {
        this.initAlphabet = initAlphabet;
    }

    public List<Transition> getTransitionList() {
        return transitionList;
    }

    public void setTransitionList(List<Transition> transitionList) {
        this.transitionList = transitionList;
    }

    public String getInitState() {
        return initState;
    }

    public void setInitState(String initState) {
        this.initState = initState;
    }

    public List<String> getFinalStates() {
        return finalStates;
    }

    public void setFinalStates(List<String> finalStates) {
        this.finalStates = finalStates;
    }

    @Override
    public String toString() {
        return "set of states" + statesAlphabet + "\n" + "alphabet: " + initAlphabet + "\n" + transitionList + "\n" + "initial state: " + initState +
        "\n" + "final states: " + finalStates;
    }

    public Automaton(String file)
    {
        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String[] line;

            line = br.readLine().split(" ");
            Collections.addAll(statesAlphabet,line);

            List<Integer> types = new ArrayList<>();
            line = br.readLine().split(" ");
            for (String type: line)
                types.add(Integer.parseInt(type));

            for (int i=0; i<statesAlphabet.size(); i++)
            {
                if (types.get(i) == 1) initState = statesAlphabet.get(i);
                if (types.get(i) == 2) finalStates.add(statesAlphabet.get(i));
            }

            int nrOfTransitions = Integer.parseInt(br.readLine());
            for (int i=0; i<nrOfTransitions; i++)
            {
                line = br.readLine().split(" ");
                transitionList.add(new Transition(line[1],line[0],line[2]));
                initAlphabet.add(line[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
