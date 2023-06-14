import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        FileWriter outputfile = new FileWriter("output.txt");
        BufferedWriter output = new BufferedWriter(outputfile);
        FileReader authorfile = new FileReader(args[0]);


        ArrayList<Author> array = new ArrayList<>();
        BufferedReader bufferedReader2 = new BufferedReader(authorfile);
        String authorline = bufferedReader2.readLine();


        while (authorline != null) {

            String[] splited = authorline.split("\\s+");
            String[] List1 = new String[11];
            for (int j =0;j< List1.length;j++){
                List1[j]="";
            }


            for (int i = 0; i < splited.length; i++) {

                List1[i] = splited[i];
            }


            array.add(new Author(List1[1], List1[2], List1[3], List1[4], List1[5], List1[6], List1[7], List1[8], List1[9], List1[10]));


            authorline = bufferedReader2.readLine();

        }


        authorfile.close();


        FileReader file = new FileReader(args[1]);


        BufferedReader bufferedReader = new BufferedReader(file);
        ArrayList<Article> articleArray = new ArrayList<>();

        String line = bufferedReader.readLine();
        while (line != null) {
            String[] splited = line.split("\\s+");
            if (splited[0].equals("read")) {

                FileReader articleFile = new FileReader(splited[1]);
                BufferedReader bufferedReader1 = new BufferedReader(articleFile);

                String articleLine = bufferedReader1.readLine();


                while (articleLine != null) {

                    String[] articleSplited = articleLine.split("\\s+");
                    String[] List2 = new String[articleSplited.length];


                    for (int i = 0; i < articleSplited.length; i++) {

                        List2[i] = articleSplited[i];
                    }

                    articleArray.add(new Article(List2[1], List2[2], List2[3], List2[4]));


                    articleLine = bufferedReader1.readLine();


                }
            } else if (splited[0].equals("list")) {
                String starter = "--------------------------------------List-------------------------------------\n";
                String finisher = "\n--------------------------------------End--------------------------------------\n";
                output.write(starter);
                for (int y = 0; y < array.size(); y++) {
                    output.write("\n" + "Author:" + array.get(y).getId() + "\t" + array.get(y).getName() + "\t" + array.get(y).getUniversity() + "\t" + array.get(y).getDepartment() + "\t" + array.get(y).getEmail() + "\n");
                    if (array.get(y).getArticle1() != null) {
                        for (int x = 0; x < articleArray.size(); x++) {
                            if (array.get(y).getArticle1().equals(articleArray.get(x).getPaperID())) {
                                output.write("+" + articleArray.get(x).getPaperID() + "\t" + articleArray.get(x).getName() + "\t" + articleArray.get(x).getPublisherName() + "\t" + articleArray.get(x).getPublishYear() + "\n");
                            }
                        }
                    }
                    if (array.get(y).getArticle2() != null) {
                        for (int x = 0; x < articleArray.size(); x++) {
                            if (array.get(y).getArticle2().equals(articleArray.get(x).getPaperID())) {
                                output.write("+" + articleArray.get(x).getPaperID() + "\t" + articleArray.get(x).getName() + "\t" + articleArray.get(x).getPublisherName() + "\t" + articleArray.get(x).getPublishYear() + "\n");
                            }
                        }
                    }
                    if (array.get(y).getArticle3() != null) {
                        for (int x = 0; x < articleArray.size(); x++) {
                            if (array.get(y).getArticle3().equals(articleArray.get(x).getPaperID())) {
                                output.write("+" + articleArray.get(x).getPaperID() + "\t" + articleArray.get(x).getName() + "\t" + articleArray.get(x).getPublisherName() + "\t" + articleArray.get(x).getPublishYear() + "\n");
                            }
                        }
                    }
                    if (array.get(y).getArticle4() != null) {
                        for (int x = 0; x < articleArray.size(); x++) {
                            if (array.get(y).getArticle4().equals(articleArray.get(x).getPaperID())) {
                                output.write("+" + articleArray.get(x).getPaperID() + "\t" + articleArray.get(x).getName() + "\t" + articleArray.get(x).getPublisherName() + "\t" + articleArray.get(x).getPublishYear() + "\n");
                            }
                        }
                    }
                    if (array.get(y).getArticle5() != null) {
                        for (int x = 0; x < articleArray.size(); x++) {
                            if (array.get(y).getArticle5().equals(articleArray.get(x).getPaperID())) {
                                output.write("+" + articleArray.get(x).getPaperID() + "\t" + articleArray.get(x).getName() + "\t" + articleArray.get(x).getPublisherName() + "\t" + articleArray.get(x).getPublishYear() + "\n");
                            }
                        }
                    }

                }

                output.write(finisher);


            } else if (splited[0].equals("completeAll")) {
                output.write("*****************************completeAll Successful****************************\n");
                for (int y = 0; y < array.size(); y++) {
                    if (array.get(y).getArticle1() == "") {
                        for (int x = 0; x < articleArray.size(); x++) {
                            if (articleArray.get(x).getPaperID().substring(0, 3).equals(array.get(y).getId())) {
                                array.get(y).setArticle1(articleArray.get(x).getPaperID());
                                break;
                            }

                        }
                    }
                    if (array.get(y).getArticle2() == "") {
                        for (int x = 0; x < articleArray.size(); x++) {
                            if (articleArray.get(x).getPaperID().substring(0, 3).equals(array.get(y).getId()) && array.get(y).getArticle1() != articleArray.get(x).getPaperID()) {
                                array.get(y).setArticle2(articleArray.get(x).getPaperID());
                                break;
                            }
                        }
                    }
                    if (array.get(y).getArticle3() == "") {
                        for (int x = 0; x < articleArray.size(); x++) {
                            if (articleArray.get(x).getPaperID().substring(0, 3).equals(array.get(y).getId()) && array.get(y).getArticle1() != articleArray.get(x).getPaperID() && array.get(y).getArticle2() != articleArray.get(x).getPaperID()) {
                                array.get(y).setArticle3(articleArray.get(x).getPaperID());
                                break;
                            }
                        }
                    }
                    if (array.get(y).getArticle4() == "") {
                        for (int x = 0; x < articleArray.size(); x++) {
                            if (articleArray.get(x).getPaperID().substring(0, 3).equals(array.get(y).getId()) && array.get(y).getArticle1() != articleArray.get(x).getPaperID() && array.get(y).getArticle2() != articleArray.get(x).getPaperID() && array.get(y).getArticle3() != articleArray.get(x).getPaperID()) {
                                array.get(y).setArticle4(articleArray.get(x).getPaperID());
                                break;
                            }
                        }
                    }
                    if (array.get(y).getArticle5() == "") {
                        for (int x = 0; x < articleArray.size(); x++) {
                            if (articleArray.get(x).getPaperID().substring(0, 3).equals(array.get(y).getId()) && array.get(y).getArticle1() != articleArray.get(x).getPaperID() && array.get(y).getArticle2() != articleArray.get(x).getPaperID() && array.get(y).getArticle3() != articleArray.get(x).getPaperID() && array.get(y).getArticle4() != articleArray.get(x).getPaperID()) {
                                array.get(y).setArticle5(articleArray.get(x).getPaperID());
                                break;

                            }
                        }
                    }

                }
            } else if (splited[0].equals("sortedAll")) {
                output.write("*************************************SortedAll Successful*************************************\n");

                for (int q = 0; q < array.size(); q++) {
                    ArrayList<String> basicArray = new ArrayList<>();
                    if (array.get(q).getArticle1() == null) {
                        continue;
                    } else if (array.get(q).getArticle2() == null) {
                        basicArray.add(array.get(q).getArticle1());
                    } else if (array.get(q).getArticle3() == null) {
                        basicArray.add(array.get(q).getArticle1());
                        basicArray.add(array.get(q).getArticle2());
                        Collections.sort(basicArray);
                        array.get(q).setArticle1((String) basicArray.get(0));
                        array.get(q).setArticle2((String) basicArray.get(1));
                    } else if (array.get(q).getArticle4() == null) {
                        basicArray.add(array.get(q).getArticle1());
                        basicArray.add(array.get(q).getArticle2());
                        basicArray.add(array.get(q).getArticle3());
                        Collections.sort(basicArray);
                        array.get(q).setArticle1((String) basicArray.get(0));
                        array.get(q).setArticle2((String) basicArray.get(1));
                        array.get(q).setArticle3((String) basicArray.get(2));
                    } else if (array.get(q).getArticle5() == null) {
                        basicArray.add(array.get(q).getArticle1());
                        basicArray.add(array.get(q).getArticle2());
                        basicArray.add(array.get(q).getArticle3());
                        basicArray.add(array.get(q).getArticle4());
                        Collections.sort(basicArray);
                        array.get(q).setArticle1((String) basicArray.get(0));
                        array.get(q).setArticle2((String) basicArray.get(1));
                        array.get(q).setArticle3((String) basicArray.get(2));
                        array.get(q).setArticle4((String) basicArray.get(3));
                    } else {
                        basicArray.add(array.get(q).getArticle1());
                        basicArray.add(array.get(q).getArticle2());
                        basicArray.add(array.get(q).getArticle3());
                        basicArray.add(array.get(q).getArticle4());
                        basicArray.add(array.get(q).getArticle5());
                        Collections.sort(basicArray);
                        array.get(q).setArticle1((String) basicArray.get(0));
                        array.get(q).setArticle2((String) basicArray.get(1));
                        array.get(q).setArticle3((String) basicArray.get(2));
                        array.get(q).setArticle4((String) basicArray.get(3));
                        array.get(q).setArticle5((String) basicArray.get(4));
                    }

                }


            } else if (splited[0].equals("del")) {
                output.write("*********************************del Successful********************************\n");
                String deleteAuthor = splited[1];
                for (int e = 0; e < array.size(); e++) {
                    if (array.get(e).getId().equals(deleteAuthor)) {
                        array.remove(array.get(e));
                    }
                }
            }
            line = bufferedReader.readLine();

        }

        file.close();
        output.close();


    }


}

