package strings;

public class WhitherStringBuilder {
    public String implicit(String[] fields) {
        var result = " ";
        for (var i = 0; i < fields.length; i++) {
            result += fields[i];
        }
        return result;
    }
    public String explicit(String[] fields){
        var sb = new StringBuilder();
        for (var i = 0; i < fields.length; i++) {
            sb.append(fields[i]);
        }
        return sb.toString();
    }
}
