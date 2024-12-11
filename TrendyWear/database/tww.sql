USE [master]
GO
/****** Object:  Database [QLShopThoiTrang]    Script Date: 11/4/2024 9:21:12 AM ******/
CREATE DATABASE [QLShopThoiTrang]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLShopThoiTrang', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\QLShopThoiTrang.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLShopThoiTrang_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\QLShopThoiTrang_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [QLShopThoiTrang] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLShopThoiTrang].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLShopThoiTrang] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLShopThoiTrang] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLShopThoiTrang] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLShopThoiTrang] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLShopThoiTrang] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLShopThoiTrang] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLShopThoiTrang] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLShopThoiTrang] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLShopThoiTrang] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLShopThoiTrang] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLShopThoiTrang] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLShopThoiTrang] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLShopThoiTrang] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLShopThoiTrang] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLShopThoiTrang] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QLShopThoiTrang] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLShopThoiTrang] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLShopThoiTrang] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLShopThoiTrang] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLShopThoiTrang] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLShopThoiTrang] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLShopThoiTrang] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLShopThoiTrang] SET RECOVERY FULL 
GO
ALTER DATABASE [QLShopThoiTrang] SET  MULTI_USER 
GO
ALTER DATABASE [QLShopThoiTrang] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLShopThoiTrang] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLShopThoiTrang] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLShopThoiTrang] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLShopThoiTrang] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLShopThoiTrang] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QLShopThoiTrang] SET QUERY_STORE = ON
GO
ALTER DATABASE [QLShopThoiTrang] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QLShopThoiTrang]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 11/4/2024 9:21:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maHD] [nvarchar](50) NOT NULL,
	[maSP] [nvarchar](50) NOT NULL,
	[soLuong] [int] NOT NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC,
	[maSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/4/2024 9:21:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHD] [nvarchar](50) NOT NULL,
	[ngayLap] [datetime] NOT NULL,
	[thanhToan] [nvarchar](max) NOT NULL,
	[maNV] [nvarchar](50) NOT NULL,
	[maKH] [nvarchar](50) NOT NULL,
	[khuyenMai] [varchar](10) NOT NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/4/2024 9:21:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKH] [nvarchar](50) NOT NULL,
	[tenKH] [nvarchar](max) NOT NULL,
	[diaChi] [nvarchar](max) NOT NULL,
	[dienThoai] [nchar](10) NOT NULL,
	[soDiem] [int] NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 11/4/2024 9:21:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[maLoai] [nvarchar](50) NOT NULL,
	[tenLoai] [nvarchar](max) NOT NULL,
	[moTa] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_LoaiSanPham] PRIMARY KEY CLUSTERED 
(
	[maLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 11/4/2024 9:21:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[maNCC] [nvarchar](50) NOT NULL,
	[tenNCC] [nvarchar](max) NOT NULL,
	[diaChi] [nvarchar](max) NOT NULL,
	[dienThoai] [nchar](10) NOT NULL,
	[email] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[maNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/4/2024 9:21:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [nvarchar](50) NOT NULL,
	[tenNV] [nvarchar](max) NOT NULL,
	[dienThoai] [nchar](10) NOT NULL,
	[Email] [nvarchar](max) NOT NULL,
	[luong] [money] NOT NULL,
	[diaChi] [nvarchar](max) NOT NULL,
	[chucVu] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 11/4/2024 9:21:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSP] [nvarchar](50) NOT NULL,
	[tenSP] [nvarchar](max) NOT NULL,
	[mauSac] [nvarchar](50) NOT NULL,
	[kichCo] [nchar](5) NOT NULL,
	[hinhAnh] [nvarchar](max) NOT NULL,
	[gia] [money] NOT NULL,
	[thuongHieu] [nvarchar](max) NOT NULL,
	[soLuongTon] [int] NOT NULL,
	[maNCC] [nvarchar](50) NOT NULL,
	[maLoai] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[maSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 11/4/2024 9:21:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[tenTK] [nvarchar](50) NOT NULL,
	[matKhau] [nvarchar](60) NOT NULL,
	[loaiTK] [nvarchar](max) NOT NULL,
	[maNV] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[tenTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'0ad2090c-ce2c-4c57-b8d5-400746a82a53', N'SP01', 2)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'0ad2090c-ce2c-4c57-b8d5-400746a82a53', N'SP04', 2)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'1835287f-a1b6-40b5-bffb-15fb545b9e5e', N'SP03', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'1835287f-a1b6-40b5-bffb-15fb545b9e5e', N'SP09', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'2ff4ed4d-fdee-4fb9-b977-0666d141ee18', N'SP09', 2)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'39b79a99-90c0-4543-b16b-c27a81cba91d', N'SP02', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'39b79a99-90c0-4543-b16b-c27a81cba91d', N'SP04', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'54de64b4-45d3-4c5e-9704-351ad453c838', N'SP04', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'54de64b4-45d3-4c5e-9704-351ad453c838', N'SP05', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'5803a392-372b-4bc3-b5d9-3a0cf8137bc4', N'SP02', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'5803a392-372b-4bc3-b5d9-3a0cf8137bc4', N'SP07', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'5803a392-372b-4bc3-b5d9-3a0cf8137bc4', N'SP09', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'5a9c3a04-d293-48fd-b579-b9deb503e477', N'SP01', 2)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'5a9c3a04-d293-48fd-b579-b9deb503e477', N'SP08', 2)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'6bcdf8fa-932d-4b8c-8f0c-58ff41eede5a', N'SP08', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'6bcdf8fa-932d-4b8c-8f0c-58ff41eede5a', N'SP10', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'883e8e3d-53ee-4dcb-be9b-ca479b3c5996', N'SP03', 2)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'883e8e3d-53ee-4dcb-be9b-ca479b3c5996', N'SP04', 2)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'8dd7ca07-0dec-4b56-a5b1-c9be5a2e2163', N'SP10', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'8dd7ca07-0dec-4b56-a5b1-c9be5a2e2163', N'SP11', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'9610e755-c11a-4f9f-8bfc-9c1108505e56', N'SP04', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'9610e755-c11a-4f9f-8bfc-9c1108505e56', N'SP09', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'fc7d5763-6e34-48f0-8554-797d45391abb', N'SP05', 1)
GO
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'0ad2090c-ce2c-4c57-b8d5-400746a82a53', CAST(N'2023-09-06T13:20:23.467' AS DateTime), N'Chuyển khoản', N'NV01', N'KH01', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'1835287f-a1b6-40b5-bffb-15fb545b9e5e', CAST(N'2024-10-28T10:43:24.210' AS DateTime), N'Tiền mặt', N'NV01', N'KH02', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'2ff4ed4d-fdee-4fb9-b977-0666d141ee18', CAST(N'2024-10-28T11:00:37.597' AS DateTime), N'Tiền mặt', N'NV02', N'KH01', N'5%')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'39b79a99-90c0-4543-b16b-c27a81cba91d', CAST(N'2024-10-19T22:16:02.370' AS DateTime), N'Tiền mặt', N'NV02', N'KH02', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'54de64b4-45d3-4c5e-9704-351ad453c838', CAST(N'2024-08-17T10:12:29.347' AS DateTime), N'Tiền mặt', N'NV01', N'KH01', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'5803a392-372b-4bc3-b5d9-3a0cf8137bc4', CAST(N'2024-08-19T12:14:28.477' AS DateTime), N'Tiền mặt', N'NV01', N'KH02', N'5%')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'5a9c3a04-d293-48fd-b579-b9deb503e477', CAST(N'2024-07-06T13:23:48.097' AS DateTime), N'Chuyển khoản', N'NV02', N'KH01', N'5%')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'6bcdf8fa-932d-4b8c-8f0c-58ff41eede5a', CAST(N'2024-10-19T21:05:46.320' AS DateTime), N'Tiền mặt', N'NV02', N'KH02', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'883e8e3d-53ee-4dcb-be9b-ca479b3c5996', CAST(N'2024-07-06T13:22:42.737' AS DateTime), N'Tiền mặt', N'NV02', N'KH01', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'8dd7ca07-0dec-4b56-a5b1-c9be5a2e2163', CAST(N'2024-10-28T09:24:54.163' AS DateTime), N'Tiền mặt', N'NV01', N'KH02', N'5%')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'9610e755-c11a-4f9f-8bfc-9c1108505e56', CAST(N'2024-10-28T10:49:46.980' AS DateTime), N'Tiền mặt', N'NV01', N'KH01', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'fc7d5763-6e34-48f0-8554-797d45391abb', CAST(N'2024-01-08T18:19:43.780' AS DateTime), N'Tiền mặt', N'NV01', N'KH02', N'5%')
GO
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [diaChi], [dienThoai], [soDiem]) VALUES (N'KH01', N'Khách Hàng', N'121', N'1111111111', 1)
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [diaChi], [dienThoai], [soDiem]) VALUES (N'KH02', N'Huynh Trương', N'abc', N'0123456789', 3)
GO
INSERT [dbo].[LoaiSanPham] ([maLoai], [tenLoai], [moTa]) VALUES (N'L01', N'Áo phong', N'Áo phông là trang phục cơ bản, làm từ cotton thoáng mát, dễ phối đồ.  ')
INSERT [dbo].[LoaiSanPham] ([maLoai], [tenLoai], [moTa]) VALUES (N'L02', N'Áo sơ mi', N'Áo sơ mi là trang phục thanh lịch, thường làm từ cotton hoặc polyester. ')
GO
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diaChi], [dienThoai], [email]) VALUES (N'NCC02', N'Thiên Đường Thời Trang', N'Cần Thơ', N'1122334455', N'thienduongthoitrang@gmail.com')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diaChi], [dienThoai], [email]) VALUES (N'NCC03', N'Nhà Kho Khổng Lồ', N'Cà Mau', N'1122448855', N'nhakhokhonglo@gmail.com')
GO
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [dienThoai], [Email], [luong], [diaChi], [chucVu]) VALUES (N'NV01', N'Phan Uyên Nhi', N'1111111111', N'phanuyennhi@gmail.com', 120000.0000, N'Đà Nẵng', N'Nhân viên')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [dienThoai], [Email], [luong], [diaChi], [chucVu]) VALUES (N'NV02', N'Phương Nhi', N'3333333363', N'phuongnhi@gmail.com', 12222.0000, N'Long An', N'Quản lý')
GO
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP01', N'Áo phong cổ tròn', N'Hồng', N'M    ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_01.jpg', 150000.0000, N'Clouzy', 80, N'NCC02', N'L01')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP02', N'Áo sơ mi họa tiết ', N'Xanh biển', N'L    ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_02.jpg', 230000.0000, N'Levent', 187, N'NCC03', N'L02')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP03', N'Áo ấm ', N'Đen', N'XL   ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_03.jpg', 300000.0000, N'Hoodie', 96, N'NCC03', N'L01')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP04', N'Áo thun ', N'Be', N'L    ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_04.jpg', 500000.0000, N'Hades', 83, N'NCC03', N'L01')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP05', N'Áo len', N'Vàng', N'L    ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_05.jpg', 700000.0000, N'Cloudzy', 180, N'NCC03', N'L01')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP06', N'Sơ mi mùa thu', N'Trắng', N'M    ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_06.png', 350000.0000, N'Levent', 95, N'NCC03', N'L02')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP07', N'Áo sơ mi trơn', N'Trắng', N'XL   ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_07.jpg', 400000.0000, N'Levent', 97, N'NCC03', N'L02')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP08', N'Sơ mi caro', N'Xanh', N'M    ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_08.jpg', 400000.0000, N'Levent', 109, N'NCC03', N'L02')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP09', N'Váy', N'Trắng', N'M    ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_09.jpg', 300000.0000, N'Evisu', 111, N'NCC03', N'L01')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP10', N'Áo thun có cổ', N'Xám', N'M    ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_10.jpg', 120000.0000, N'Evisu', 96, N'NCC03', N'L01')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP11', N'Áo thun gấu', N'Trắng', N'L    ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_11.jpg', 70000.0000, N'Evisu', 118, N'NCC03', N'L01')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP12', N'Áo thun cú mèo', N'Đỏ', N'XXL  ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_12.jpg', 300000.0000, N'Evisu', 119, N'NCC03', N'L01')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP13', N'Áo thể thao', N'Đen', N'XL   ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_13.jpg', 200000.0000, N'EA sport', 300, N'NCC03', N'L01')
GO
INSERT [dbo].[TaiKhoan] ([tenTK], [matKhau], [loaiTK], [maNV]) VALUES (N'NV01', N'$2a$10$kWu9/VdrZahfmm..K5cniu0YQoPHUMmuAHOXpbKPmHBNVK8ZfPqyK', N'Nhân viên', N'NV01')
INSERT [dbo].[TaiKhoan] ([tenTK], [matKhau], [loaiTK], [maNV]) VALUES (N'NV02', N'$2a$10$YGv9tXiBbA0wT8Jpv45aUuT1Fz450URYfmbLdEBHQS7joNJn42ex6', N'Quản lý', N'NV02')
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ('') FOR [khuyenMai]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDon] ([maHD])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_SanPham] FOREIGN KEY([maSP])
REFERENCES [dbo].[SanPham] ([maSP])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_SanPham]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_LoaiSanPham] FOREIGN KEY([maLoai])
REFERENCES [dbo].[LoaiSanPham] ([maLoai])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_LoaiSanPham]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_NhaCungCap] FOREIGN KEY([maNCC])
REFERENCES [dbo].[NhaCungCap] ([maNCC])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_NhaCungCap]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
USE [master]
GO
ALTER DATABASE [QLShopThoiTrang] SET  READ_WRITE 
GO
