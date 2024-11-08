## Tugas
#### Handle Data Student

1. Buat Class Utama
   
   Mulai dengan membuat kelas Student dengan atribut dasar seperti name dan npm, dst beserta method untuk mengaksesnya

2. Menambah Fungsi Baru
   
   Tambahkan metode baru seperti addGrade atau getGPA untuk menangani nilai mahasiswa

3. Membangun Class Tambahan
   
   Tambahkan kelas lain seperti Course yang dapat menyimpan daftar object Student
# 
# 
# Sistem Informasi Mahasiswa

## Studi Kasus
Sebuah universitas ingin membuat sistem yang dapat menyimpan data mahasiswa, mata kuliah yang diambil, dan menghitung rata-rata IPK mahasiswa. Setiap mahasiswa memiliki atribut identitas dasar dan daftar nilai sesuai dengan mata kuliah yang diambil. Setiap mata kuliah memiliki atribut penting seperti SKS dan harus mampu mengelola daftar mahasiswa yang terdaftar.

---

## Rancangan Program

### 1. Class `Student`

   Kelas `Student` berfungsi sebagai representasi data setiap mahasiswa.

   - **Atribut yang Diperlukan:**
     - `name` : `String` – Menyimpan nama mahasiswa.
     - `npm` : `String` – Nomor identitas unik mahasiswa.
     - `grades` : `ArrayList` – Menyimpan nilai setiap mata kuliah yang diambil ( berisi object `grades` )
     - `courses` : `ArrayList` - Menyimpan mata kuliah yang diambil ( berisi object `Course` )

   - **Metode yang Diperlukan:**
     - `Constructor` : name, npm
     - `addGrade(course, grade)` : Menambahkan nilai (`grade`) pada mata kuliah (`course`).
     - `getGPA()` : Menghitung nilai rata-rata (IPK) mahasiswa berdasarkan `grades` yang tersimpan, dengan mempertimbangkan SKS dari setiap mata kuliah.
     - `getCourseStudent` : Untuk melihat mata kuliah yang diambil oleh mahasiswa

---

### 2. Class `Course`

   Kelas `Course` mewakili mata kuliah yang dapat diambil mahasiswa

   - **Atribut yang Diperlukan:**
     - `courseName` : `String` – Nama mata kuliah.
     - `courseCode` : `String` – Kode unik mata kuliah.
     - `sks` : `Integer` – Jumlah SKS mata kuliah.
     - `studentList` : `List` – Menyimpan daftar objek `Student` yang mengambil mata kuliah ini.

   - **Metode yang Diperlukan:**
     - `Constructor` : course name, course code, sks
     - `addStudent(student)` : Menambahkan mahasiswa ke dalam `studentList`. Nama mahasiswa boleh duplikat tapi NPM nya harus unique, buat validasi agar npm tidak duplikat.
     - `calculateAverageGrade()` : Menghitung rata-rata nilai mahasiswa yang mengambil mata kuliah ini, dengan mengambil nilai dari setiap mahasiswa dalam `studentList`.

---

### 3. Class `Grades`

   Kelas `Grades` mewakili nilai setiap matkul yang diambil oleh mahasiswa

   - **Atribut yang Diperlukan:**
     - `grade` : `Float` – Grade mata kuliah
     - `course` : `Course` – Object Mata kuliah ( Course )

   - **Metode yang Diperlukan:**
     - `Constructor` : course, grade
     - `getCourse()` : Mengambil data mata kuliah
     - `getGrade()` : Mengambil data grade mata kuliah

---

### 4. Fitur Penghitungan GPA

   - **Formula GPA**: Setiap `Student` memiliki metode `getGPA()` yang menghitung GPA dengan rumus:
     - GPA = Total (nilai * SKS) / Total SKS.
   - **Validasi SKS**: Pastikan setiap SKS dihitung dengan benar tanpa duplikasi saat mahasiswa mengambil mata kuliah.

---

### 5. Fitur Koneksi Antar Kelas

Untuk menghubungkan data `Student` dan `Course`, sistem dapat mengikuti alur berikut:

- Kelas `Student` memiliki atribut `courses`, berupa daftar objek `Course` yang mewakili semua mata kuliah yang diambil mahasiswa.
- Kelas `Course` memiliki atribut `studentList`, yang berisi daftar objek `Student` untuk menyimpan mahasiswa yang terdaftar di mata kuliah tersebut.

#### Alur Menambahkan Mata Kuliah dan Mahasiswa

1. **Instansiasi Mata Kuliah (Course)**:
   - Mata kuliah dapat diinstansiasi sebagai objek `Course` independen.
   
2. **Menambahkan Mahasiswa ke Mata Kuliah (Course)**:
   - Gunakan metode `addStudent(student)` pada objek `Course` untuk mendaftarkan mahasiswa yang mengambil mata kuliah tersebut.
   
3. **Relasi Dua Arah**:
   - Pada saat mahasiswa mengambil mata kuliah, metode `addGrade(course, grade)` di `Student` dapat digunakan untuk:
     - Menambahkan objek `Course` ke daftar `courses` milik `Student`.
     - Menambahkan mahasiswa tersebut ke `studentList` pada objek `Course`.

Dengan pendekatan ini, kelas `Course` dapat berdiri sendiri sebagai entitas independen, dan mahasiswa dapat ditambahkan kapan saja.

Dengan requirement ini, sistem dapat berjalan dengan baik dan memastikan interaksi antara kelas `Student` dan `Course` berfungsi dengan benar. Setiap mahasiswa dapat ditambahkan ke dalam mata kuliah yang diambil, dan IPK mahasiswa dapat dihitung otomatis sesuai dengan mata kuliah dan nilai yang telah tersimpan.
