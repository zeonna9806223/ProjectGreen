USE [YI]
GO
/****** Object:  Table [dbo].[AccessRecord]    Script Date: 2020/4/13 下午 12:12:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AccessRecord](
	[AccessID] [nchar](10) NOT NULL,
	[AccessAccount] [varchar](18) NULL,
	[AccessTime] [datetime] NULL,
	[AccessType] [varchar](40) NULL
) ON [PRIMARY]
GO
