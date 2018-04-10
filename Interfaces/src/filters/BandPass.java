package filters;

public class BandPass extends Filter {
    double lowCutoff,highCutoff;
    public BandPass(double lowCut,double highCut){
        this.lowCutoff = lowCut;
        this.highCutoff = highCut;
    }

    public Waveform process(Waveform input) {
        return input;
    }
}
