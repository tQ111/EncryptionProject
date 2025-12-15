class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){
    String text = "daniel caesar is goated";
    
    //caesar cipher
    print("\nCaesar Cipher - '" + text + "':");
    print(caesar(text));

    //backwards
    print("\nBackwards - '" + text + "':");
    print(backwards(text));

    //turn into ascii
    print("\nASCII - '" + text + "':");
    print(ascii(text));

    //substituting values w the symbol things
    print("\nSubstitution - '" + text + "':");
    print(substitution(text));

    //put it all together
    print("\nEverything together - '" + text + "':");
    print(ascii(caesar(substitution(backwards(text)))));
    print("Without ASCII:");
    print(caesar(substitution(backwards(text))));

    //decode attempt 12
    String cryp = ascii(caesar(substitution(backwards(text))));
    print("\nDecrypting: " + cryp);
    print(decode(cryp));

    print("\n");
  }

  String caesar(String txt){
  String build="";
  for(int i = 0; i < txt.length(); i++){
    char ch = txt.charAt(i);
    int ascii = (int)ch;
    if(ch == 'x' || ch == 'y' || ch == 'z' || ch == 'X' || ch == 'Y' || ch == 'Z'){
      ch = (char)(ascii - 29);
      build += ch;
    }else{
      ch = (char)(ascii + 3);
      build += ch;
    }
  }
     
    return build;
  }

  //turn into ascii
  String ascii(String S){
    String build = "";
    for(int i = 0; i < S.length(); i++){
      char ch = S.charAt(i);
      int ascii = (int)ch;
      build += (ascii + "-");
    }
      return build.substring(0, build.length()-1);
    }

  //substitution
  String substitution(String S){
    String build = "";
    
    for(int i = 0; i < S.length(); i++){
      if(S.charAt(i) == 'A' || S.charAt(i) == 'a'){
        int code = 8761;
        char unicode = (char)code;
        build += unicode;
      }else if(S.charAt(i) == 'E' || S.charAt(i) == 'e'){
        int code = 8762;
        char unicode = (char)code;
        build += unicode;
      }else if(S.charAt(i) == 'I' || S.charAt(i) == 'i'){
        int code = 8763;
        char unicode = (char)code;
        build += unicode;
      }else if(S.charAt(i) == 'O' || S.charAt(i) == 'o'){
        int code = 8764;
        char unicode = (char)code;
        build += unicode;
      }else if(S.charAt(i) == 'U' || S.charAt(i) == 'u'){
        int code = 8765;
        char unicode = (char)code;
        build += unicode;
      }else if(S.charAt(i) == 'Y' || S.charAt(i) == 'y'){
        int code = 8766;
        char unicode = (char)code;
        build += unicode;
      }else{
        build += S.charAt(i);
      }
    }

    return build;
  }

  //backwards
  String backwards(String S){
    String build = "";
    for(int i = S.length()-1; i >= 0; i--){
      build += S.charAt(i);
    }
    return build;  
  }

  //wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
  //decode
  String decode(String S){
    String build1 = "";
    int current = 0;

    //un ascii
    for (int i = 0; i < S.length(); i++){
        char ch = S.charAt(i);

        if(ch == '-'){
            build1 += (char)current;
            current = 0;
        }else{
            current = (current * 10) + (ch - '0'); 
        }
    }

    build1 += (char) current;

    //un backwards
    String build2 = "";
    for(int e = build1.length() - 1; e >= 0; e--){
        build2 += build1.charAt(e);
    }

   //un caesar
   String build3 = "";
    for(int w = 0; w < build2.length(); w++){
        char c = build2.charAt(w);
            build3 += (char)(c - 3);
    }

    //symbols back to vowels
    String build4 = "";
      for(int t = 0; t < build3.length(); t++){
        if((int)build3.charAt(t) < 1000){
            build4 += build3.charAt(t);
        }else if(build3.charAt(t) == ' '){
          build4 += ' ';
        }else if((int)build3.charAt(t) == 8761){
          build4 += 'A';
        }else if((int)build3.charAt(t) == 8762){
          build4 += 'E';
        }else if((int)build3.charAt(t) == 8763){
          build4 += 'I';
        }else if((int)build3.charAt(t) == 8764){
          build4 += 'O';
        }else if((int)build3.charAt(t) == 8765){
          build4 += 'U';
        }else if((int)build3.charAt(t) == 8766){
          build4 += 'Y';
        }else{
          build4 += "";
        }
    }

    return build4;
    
  }



}