package filters;

public class HighPass extends Filter {
    double lowCutoff, highCutoff;
    public HighPass(double lowCut,double highCut){
        lowCutoff = lowCut;
        highCutoff = highCut;
    }

    public Waveform process(Waveform input) {
        return input;//Dummy processing;
    }
}
