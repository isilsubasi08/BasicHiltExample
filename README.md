# HİLT ÖĞRENELİM 🎉

 Yazılımın temeli olan Solid prensiplerinin son basamağı Dependency Inversion ve onu uygularken neler yapacağımızı öğrenelim.

## Nedir Dependency Inversion ? 
 Üst sınıf alt sınıflara bağımlı olmamalıdır. Yani alt sınıfta yapacağım değişiklik üst sınıfı etkilememelidir. Eğer alt sınıfta bir değişiklik yaparsak ve bu üst sınıfı etkilerse SOLİD prensiplerine uymamış oluruz. 

## Dependency Inversion Uygulama Teknikleri

- Dependecy Injection
- Service Lacotor
- Manuel DI vb.
  
## Dependency Injection 💊
Sınıfı ve nesneyi bağımsızlaştırmamıza yarayan bağımlılıkları kopararak daha test edilebilir ve clean code yazabilmemiz için oluşturulmuş bir tekniktir.

## Dependecy Injection Kütüphaneleri
- Koin
- Dagger
- <b>Hilt</b>
  <br>
Biz basit bir uygulama yapıp Hilt kütüphanesinin tüm temellerini öğreneceğiz.

## HİLT 🌙
Jetpack tarafından önerilen bir dependecy injection(DI) kütüphanesidir.
Dagger kütüphanesinin üzerine kurulmuş ve Dagger'ın tüm avantajlarını basitleştirerek koruyan daha anlaşılabilir yapıda kütüphanedir.<br>
Kullanacağımız annotasyonlarla bu entegre işlemini kolaylıkla yapacağız.

## Hilt’in desteklediği android sınıfları
- Activity
- Fragment
- View
- Service
- BroadcastReceiver
  
## Kullanacağımız Annotasyonlar 

- @HiltAndroidApp
- @AndroidEntryPoint
- @ViewModelInject
- @Inject
- @Module
- @Provide
- @InstallIn

Uygulama yaparken bütün annotasyonların ne işe yaradığından bahsedeceğiz.

## Başlayalım 🌈
## Hilt’i projelerimize nasıl entegre edebiliriz?

 * Project seviyesine build.gradle dosyasına aşağıdaki kodu ekleyelim.<br>
  
   `classpath 'com.google.dagger:hilt-android-gradle-plugin:2.44'`

  * Daha sonra app seviyesindeki build.gradle dosyasına aşağıdaki eklemeleride yapalım.<br> 
	
    `id 'kotlin-kapt'` <br>
    `id 'dagger.hilt.android.plugin'`<br>
     <br> 
       `implementation "com.google.dagger:hilt-android:2.38.1"`<br>
    `kapt "com.google.dagger:hilt-compiler:2.38.1" ` 

Artık Hilt kütüphanesini kullanabiliriz..✨  










  
  






