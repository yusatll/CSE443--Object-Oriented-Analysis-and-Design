Merhaba hocam;
Part1 de Singelton sınıfının tam olarak nereden implement edilmesi gerektiğini anlamadım. 
İlk soruda Object sınıfından inherit edilince clone methodu yeni obje oluşturur mu diye soruyorsunuz diye anladım. Kodda iki tane Singleton
sınıfı yaptım. Singleton_1 olan Object den implement oluyor. Orada clone metodunu kendimiz yazmamız gerekiyor. 
Object sınıfı içinde clone metodu yok. Kendimiz istediğimiz gibi o metodu yazabiliriz. Ben yeni bir singleton_1 objesi döndürüyorum. 
Ama sınıf içinde oluşturduğumuz tek nesneyi de döndürebiliriz. 


Cloneable bir parent ten implement edilince diye ayrı olarak soru var.Bunu içinde ikinci bir Singleton_2 sınıfı oluşturdum. 
Burada clone methodunu override edip içinde throws CloneNotSupportedException dememiz lazım ki clone objesi oluşturmasın. 
Ya da sınıfın içinde oluşturduğumuz tek nesneyi de return edebiliriz. 

İki farklı soru olarak anladığım için iki tane sınıf oluşturdum. 

Part 4:
Buradaki ilk soruda ben get ve set işlemlerinin senkron olmasını istediğinizi anladım. metodlara syncronized ekledim.
ikinci soruda da set'ler bitmeden get'ler çalışmayacak diye anladım. Setlerin sayısını alıyorum. set çağırıldıkça o counterı güncelliyorum.
setler bittikten sonra getlere izin veriyorum. 