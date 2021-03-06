USE [YI]
GO
/****** Object:  Table [dbo].[MemberPhoto]    Script Date: 2020/4/13 下午 12:12:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MemberPhoto](
	[PhotoID] [int] NOT NULL,
	[PhotoSaveTime] [datetime] NULL,
	[PhotoDescription] [nvarchar](20) NULL,
	[PhotoName] [nvarchar](20) NULL,
	[PhotoSize] [nvarchar](20) NULL,
	[PhotoOwner] [nchar](10) NULL,
 CONSTRAINT [PK_MemberPhoto] PRIMARY KEY CLUSTERED 
(
	[PhotoID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
