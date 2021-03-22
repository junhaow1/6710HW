package comp1110.homework.J08;

public class Sentence {

    public static class Word {
        String value;
        Type type;

        public Word(String value, Type type) {
            this.value = value;
            this.type = type;
        }
    }

    public enum Type {
        NOUN,
        ADJECTIVE,
        VERB;
    }
    public Word[] words;

    public int size;

    public Sentence(int size) {
        this.size = size;
    }

    public boolean isValid(){
        int count = 0;
        if (size<1){
            return false;
        } else if (words[words.length-1].type.equals(Type.ADJECTIVE)){
            return false;
        } else {
            for (int i =0;i<words.length;i++){
                if (words[i].type.equals(Type.NOUN)){
                    if (i== words.length-1){
                    } else {
                        if (! words[i+1].type.equals(Type.VERB)){
                            return false;
                        }
                    }
                } else if (words[i].type.equals(Type.ADJECTIVE)){
                    if (i== words.length-1){

                    } else {
                        if ( words[i+1].type.equals(Type.VERB)){
                            return false;
                        }
                    }
                } else if (words[i].type.equals(Type.VERB)){
                    count ++;

                } else {

                }
            }
        }


        if(count!=1){
            return false;
        }

        return false;
    }


}
