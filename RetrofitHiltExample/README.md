# RETROFİT-HİLT ÖĞRENELİMM🎉
## Hilt Modules
Hilte binding eklemek için başka bir deyişle Hilte başka türdeki örnekleri nasıl sağlayacağımızı söylemek için kullanırız.</br>
Modüllerde , projenizde yer almayan interface ve class gibi constructor inject yapamayacağımız türler için binding eklemek için kullanılır.

Örnek olarak <b>OkHttpClient</b> kütüphanesini verebiliriz.</br>
OkHttpClient örneği oluşturmak için Builder kullanmamız gerekir. </br>
Hilt modülü, <b>@Module</b> ve <b>@InstallIn</b> ile açıklama eklenmiş bir sınıftır.</br>
<b>@Module</b>, Hilt'e bunun bir modül olduğunu söyler</br>
<b>@InstallIn</b>, Hilt'e bir Hilt bileşeni belirterek bağlamaların bulunduğu kapsayıcıları(componentleri) söyler.

## Module nasıl oluşturulur ?
 Öncelikle di paketi oluşturup içerisinde object tipinde ApiModule isminde oluşturuyoruz.</br>
Hilte constructor inject yapamayacağımız türleri nasıl sağlayacağını söylemek için <b>@Provides</b> açıklamasını kullanıyoruz.</br>

<b>@Provides</b>ek açıklamalı bir fonksiyonun gövdesi, Hilt'in bu türden bir örnek sağlaması gerektiğinde yürütülür.</br>

<b>@Provides</b> açıklamalı fonksiyonun dönüş türü, Hilt'e bağlama türünü, işlevin örneklerini sağladığı türü söyler. İşlev parametreleri, o türün bağımlılıklarıdır.

## TMDB Api Kullanarak Oluşturduğum Proje
![movielist](https://github.com/isilsubasi08/BasicHiltExample/blob/main/gif/MoviesList.gif)





 





         

















  
  






