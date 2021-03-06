USE [YI]
GO
/****** Object:  Table [dbo].[MemberProfile]    Script Date: 2020/4/13 下午 12:12:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MemberProfile](
	[ProfileID] [nchar](10) NOT NULL,
	[ProfileHeight] [int] NULL,
	[ProfileWeight] [int] NULL,
	[ProfileBlood] [tinyint] NULL,
	[ProfileMarr] [tinyint] NULL,
	[ProfileEducation] [nvarchar](30) NULL,
	[ProfileJob] [nchar](20) NULL,
	[ProfileIncome] [varchar](16) NULL,
	[ProfileBelief] [nvarchar](10) NULL,
	[ProfilePersonalityType] [nvarchar](100) NULL,
	[ProfileSmoke] [tinyint] NULL,
	[ProfileWine] [tinyint] NULL,
	[ProfileIntroduce] [text] NULL,
	[ProfileFitLook] [nvarchar](10) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
