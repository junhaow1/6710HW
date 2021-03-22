package comp1110.homework.J08;

public class Sentence {

    public static class Word {

        public enum Type {
            NOUN,
            ADJECTIVE,
            VERB;
        }

        public String value;
        public Type type;

        public Word(String value, Type type) {
            this.value = value;
            this.type = type;
        }
    }


    public Word[] words;

    public int size;

    public Sentence(int size) {
        this.size = size;
        words = new Word[size];
    }

//    public Sentence(Word[] words) {
//        this.words = words;
//    }

    public boolean isValid(){
        int count = 0;
        if (size<1){
            return false;
        } else if (words[words.length-1].type.equals(Word.Type.ADJECTIVE)){
            return false;
        } else {
            for (int i =0;i<words.length;i++){
                if (words[i].type.equals(Word.Type.NOUN)){
                    if (i== words.length-1){
                    } else {
                        if (! words[i+1].type.equals(Word.Type.VERB)){
                            return false;
                        }
                    }
                } else if (words[i].type.equals(Word.Type.ADJECTIVE)){
                    if (i== words.length-1){

                    } else {
                        if ( words[i+1].type.equals(Word.Type.VERB)){
                            return false;
                        }
                    }
                } else if (words[i].type.equals(Word.Type.VERB)){
                    count ++;

                } else {

                }
            }
        }

        if(count!=1){
            return false;
        }

        return true;
    }


}
