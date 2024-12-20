CREATE DATABASE [QLShopThoiTrang]
USE [QLShopThoiTrang]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 12/12/2024 12:06:31 PM ******/
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
/****** Object:  Table [dbo].[HoaDon]    Script Date: 12/12/2024 12:06:31 PM ******/
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
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/12/2024 12:06:31 PM ******/
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
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 12/12/2024 12:06:31 PM ******/
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
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 12/12/2024 12:06:31 PM ******/
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
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/12/2024 12:06:31 PM ******/
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
/****** Object:  Table [dbo].[SanPham]    Script Date: 12/12/2024 12:06:31 PM ******/
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
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 12/12/2024 12:06:31 PM ******/
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
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'1f2fa758-f996-46d8-88d3-d55d0236d277', N'SP06', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'2ff4ed4d-fdee-4fb9-b977-0666d141ee18', N'SP09', 2)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'39b79a99-90c0-4543-b16b-c27a81cba91d', N'SP02', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'39b79a99-90c0-4543-b16b-c27a81cba91d', N'SP04', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'400d7afb-d3c5-43a9-90c4-8d4beefc81bf', N'SP06', 2)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'4b999b2a-31a8-425c-8070-f808e946998e', N'SP04', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'4b999b2a-31a8-425c-8070-f808e946998e', N'SP11', 2)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'54de64b4-45d3-4c5e-9704-351ad453c838', N'SP04', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'54de64b4-45d3-4c5e-9704-351ad453c838', N'SP05', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'5803a392-372b-4bc3-b5d9-3a0cf8137bc4', N'SP02', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'5803a392-372b-4bc3-b5d9-3a0cf8137bc4', N'SP07', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'5803a392-372b-4bc3-b5d9-3a0cf8137bc4', N'SP09', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'5a9c3a04-d293-48fd-b579-b9deb503e477', N'SP01', 2)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'5a9c3a04-d293-48fd-b579-b9deb503e477', N'SP08', 2)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'6bcdf8fa-932d-4b8c-8f0c-58ff41eede5a', N'SP08', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'6bcdf8fa-932d-4b8c-8f0c-58ff41eede5a', N'SP10', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'783c91c6-fbba-456f-9a81-c3fcc81b1ded', N'SP02', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'783c91c6-fbba-456f-9a81-c3fcc81b1ded', N'SP05', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'883e8e3d-53ee-4dcb-be9b-ca479b3c5996', N'SP03', 2)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'883e8e3d-53ee-4dcb-be9b-ca479b3c5996', N'SP04', 2)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'89d07039-12a2-4e29-a2a8-a6677ba57c66', N'SP06', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'8dd7ca07-0dec-4b56-a5b1-c9be5a2e2163', N'SP10', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'8dd7ca07-0dec-4b56-a5b1-c9be5a2e2163', N'SP11', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'9610e755-c11a-4f9f-8bfc-9c1108505e56', N'SP04', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'9610e755-c11a-4f9f-8bfc-9c1108505e56', N'SP09', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'a4b8e41a-69d4-4af6-bcd0-c629bac6e10c', N'SP10', 2)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'a4b8e41a-69d4-4af6-bcd0-c629bac6e10c', N'SP11', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'bb2b1972-92ed-42af-91e9-3de279aba13b', N'SP04', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'bb2b1972-92ed-42af-91e9-3de279aba13b', N'SP10', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'c77c2466-c244-4e6f-b604-30c7c225765d', N'SP08', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'c77c2466-c244-4e6f-b604-30c7c225765d', N'SP10', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'c77c2466-c244-4e6f-b604-30c7c225765d', N'SP11', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'c77c2466-c244-4e6f-b604-30c7c225765d', N'SP12', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maSP], [soLuong]) VALUES (N'fc7d5763-6e34-48f0-8554-797d45391abb', N'SP05', 1)
GO
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'0ad2090c-ce2c-4c57-b8d5-400746a82a53', CAST(N'2023-09-06T13:20:23.467' AS DateTime), N'Chuyển khoản', N'NV01', N'KH01', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'1f2fa758-f996-46d8-88d3-d55d0236d277', CAST(N'2024-11-04T09:34:56.940' AS DateTime), N'Tiền mặt', N'NV02', N'KH01', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'2ff4ed4d-fdee-4fb9-b977-0666d141ee18', CAST(N'2024-10-28T11:00:37.597' AS DateTime), N'Tiền mặt', N'NV02', N'KH01', N'5%')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'39b79a99-90c0-4543-b16b-c27a81cba91d', CAST(N'2024-10-19T22:16:02.370' AS DateTime), N'Tiền mặt', N'NV02', N'KH02', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'400d7afb-d3c5-43a9-90c4-8d4beefc81bf', CAST(N'2024-12-09T20:57:46.133' AS DateTime), N'Tiền mặt', N'NV01', N'KH01', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'4b999b2a-31a8-425c-8070-f808e946998e', CAST(N'2024-12-10T21:15:58.193' AS DateTime), N'Tiền mặt', N'NV02', N'KH01', N'5%')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'54de64b4-45d3-4c5e-9704-351ad453c838', CAST(N'2024-08-17T10:12:29.347' AS DateTime), N'Tiền mặt', N'NV01', N'KH01', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'5803a392-372b-4bc3-b5d9-3a0cf8137bc4', CAST(N'2024-08-19T12:14:28.477' AS DateTime), N'Tiền mặt', N'NV01', N'KH02', N'5%')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'5a9c3a04-d293-48fd-b579-b9deb503e477', CAST(N'2024-07-06T13:23:48.097' AS DateTime), N'Chuyển khoản', N'NV02', N'KH01', N'5%')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'6bcdf8fa-932d-4b8c-8f0c-58ff41eede5a', CAST(N'2024-10-19T21:05:46.320' AS DateTime), N'Tiền mặt', N'NV02', N'KH02', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'783c91c6-fbba-456f-9a81-c3fcc81b1ded', CAST(N'2024-12-10T20:32:07.120' AS DateTime), N'Tiền mặt', N'NV01', N'KH01', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'883e8e3d-53ee-4dcb-be9b-ca479b3c5996', CAST(N'2024-07-06T13:22:42.737' AS DateTime), N'Tiền mặt', N'NV02', N'KH01', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'89d07039-12a2-4e29-a2a8-a6677ba57c66', CAST(N'2024-11-04T10:41:07.360' AS DateTime), N'Chuyển khoản', N'NV02', N'KH01', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'8dd7ca07-0dec-4b56-a5b1-c9be5a2e2163', CAST(N'2024-10-28T09:24:54.163' AS DateTime), N'Tiền mặt', N'NV01', N'KH02', N'5%')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'9610e755-c11a-4f9f-8bfc-9c1108505e56', CAST(N'2024-10-28T10:49:46.980' AS DateTime), N'Tiền mặt', N'NV01', N'KH01', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'a4b8e41a-69d4-4af6-bcd0-c629bac6e10c', CAST(N'2024-12-12T11:23:29.647' AS DateTime), N'Tiền mặt', N'NV02', N'KH01', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'bb2b1972-92ed-42af-91e9-3de279aba13b', CAST(N'2024-12-09T21:02:26.947' AS DateTime), N'Tiền mặt', N'NV02', N'KH01', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'c77c2466-c244-4e6f-b604-30c7c225765d', CAST(N'2024-12-10T20:11:04.537' AS DateTime), N'Tiền mặt', N'NV02', N'KH01', N'Không')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [thanhToan], [maNV], [maKH], [khuyenMai]) VALUES (N'fc7d5763-6e34-48f0-8554-797d45391abb', CAST(N'2024-01-08T18:19:43.780' AS DateTime), N'Tiền mặt', N'NV01', N'KH02', N'5%')
GO
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [diaChi], [dienThoai], [soDiem]) VALUES (N'KH01', N'Khách Hàng', N'121', N'1111111111', 4)
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [diaChi], [dienThoai], [soDiem]) VALUES (N'KH02', N'Huynh Trương', N'abc', N'0123456789', 3)
GO
INSERT [dbo].[LoaiSanPham] ([maLoai], [tenLoai], [moTa]) VALUES (N'L01', N'Áo phong', N'Áo phông là trang phục cơ bản, làm từ cotton thoáng mát, dễ phối đồ.  ')
INSERT [dbo].[LoaiSanPham] ([maLoai], [tenLoai], [moTa]) VALUES (N'L02', N'Áo sơ mi', N'Áo sơ mi là trang phục thanh lịch, thường làm từ cotton hoặc polyester. ')
GO
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diaChi], [dienThoai], [email]) VALUES (N'NCC01', N'Huinh Shop', N'123 ĐL', N'1234567890', N'huinh@gmail.com')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diaChi], [dienThoai], [email]) VALUES (N'NCC02', N'Thiên Đường Thời Trang', N'Cần Thơ', N'1122334455', N'thienduongthoitrang@gmail.com')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diaChi], [dienThoai], [email]) VALUES (N'NCC03', N'Nhà Kho Khổng Lồ', N'Cà Mau', N'1122448855', N'nhakhokhonglo@gmail.com')
GO
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [dienThoai], [Email], [luong], [diaChi], [chucVu]) VALUES (N'NV01', N'Phan Uyên Nhi', N'1111111110', N'phanuyennhi@gmail.com', 120000.0000, N'Đà Nẵng', N'Nhân viên')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [dienThoai], [Email], [luong], [diaChi], [chucVu]) VALUES (N'NV02', N'Phương Nhi', N'3333333363', N'phuongnhi@gmail.com', 12222.0000, N'Long An', N'Quản lý')
GO
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP01', N'Áo phong cổ tròn', N'Hồng', N'M    ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_01.jpg', 150000.0000, N'Clouzy', 90, N'NCC02', N'L01')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP02', N'Áo sơ mi họa tiết ', N'Xanh biển', N'L    ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_02.jpg', 230000.0000, N'Levent', 186, N'NCC03', N'L02')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP03', N'Áo ấm ', N'Đen', N'XL   ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_03.jpg', 300000.0000, N'Hoodie', 96, N'NCC03', N'L01')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP04', N'Áo thun ', N'Be', N'L    ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_04.jpg', 500000.0000, N'Hades', 80, N'NCC03', N'L01')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP05', N'Áo len', N'Vàng', N'L    ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_05.jpg', 700000.0000, N'Cloudzy', 175, N'NCC03', N'L01')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP06', N'Sơ mi mùa thu', N'Trắng', N'M    ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_06.png', 350000.0000, N'Levent', 87, N'NCC03', N'L02')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP07', N'Áo sơ mi trơn', N'Trắng', N'XL   ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_07.jpg', 400000.0000, N'Levent', 96, N'NCC03', N'L02')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP08', N'Sơ mi caro', N'Xanh', N'M    ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_08.jpg', 400000.0000, N'Levent', 107, N'NCC03', N'L02')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP09', N'Váy', N'Trắng', N'M    ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_09.jpg', 300000.0000, N'Evisu', 110, N'NCC03', N'L01')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP10', N'Áo thun có cổ', N'Xám', N'M    ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_10.jpg', 120000.0000, N'Evisu', 92, N'NCC03', N'L01')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP11', N'Áo thun gấu', N'Trắng', N'L    ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_11.jpg', 70000.0000, N'Evisu', 114, N'NCC03', N'L01')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP12', N'Áo thun cú mèo', N'Đỏ', N'XXL  ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_12.jpg', 300000.0000, N'Evisu', 118, N'NCC03', N'L01')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [mauSac], [kichCo], [hinhAnh], [gia], [thuongHieu], [soLuongTon], [maNCC], [maLoai]) VALUES (N'SP13', N'Áo thể thao', N'Đen', N'XL   ', N'T:\N3_HK1\PTUD\TrendyWear\src\images\sp_13.jpg', 200000.0000, N'EA sport', 299, N'NCC03', N'L01')
GO
INSERT [dbo].[TaiKhoan] ([tenTK], [matKhau], [loaiTK], [maNV]) VALUES (N'NV01', N'$2a$10$IPISwp.QEm5QOxtj4zlPa.3h8zYSUUXUwmdkDZuiX3rCPdfy22vIO', N'Nhân viên', N'NV01')
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
