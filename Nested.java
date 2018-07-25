// iterations || counting with  nested loops

// private void Nested() {
//     int n = 10; 
//     for (int j = 1; <= n ; j ++) {
//         for (int k = 1; k <= j ; k++) {
//             System.out.print("*");
//         }
//     }
// }

// Testing Nested inside Nested 

private void example2() {
int j = 10; 
 for ( ; j >= 0; j --) {
       int finalJ = j;
       IntStream.range(0, 10 -j ).forEach (s -> {
           System.out.print(" "); 
       });
       IntStream.range(0, 2*j-1).forEach(s -> {
           System.out.print("*");
           if(s == 2*finalJ - 2) {
               System.out.printLn();
           }});
 }
}